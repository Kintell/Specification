package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.LaunchMessage;
import com.kokakiwi.kintell.spec.net.msg.ProgramsListMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class LaunchMessageCodec extends MessageCodec<LaunchMessage>
{
    public LaunchMessageCodec()
    {
        super((byte) 0x08);
    }
    
    @Override
    public LaunchMessage decode(DataBuffer buf)
    {
        LaunchMessage msg = new LaunchMessage();
        
        msg.setId(buf.readInt());
        
        msg.setBoard(buf.readString());
        
        int size = buf.readInt();
        for (int i = 0; i < size; i++)
        {
            ProgramsListMessage.Program program = new ProgramsListMessage.Program();
            program.decode(buf);
            msg.getPrograms().add(program);
        }
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, LaunchMessage msg)
    {
        buf.writeInteger(msg.getId());
        buf.writeString(msg.getBoard());
        buf.writeInteger(msg.getPrograms().size());
        for (ProgramsListMessage.Program program : msg.getPrograms())
        {
            program.encode(buf);
        }
    }
    
}
