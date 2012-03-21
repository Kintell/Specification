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
        
        msg.setBoard(buf.readString());
        msg.setId(buf.readInt());
        
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
        buf.writeString(msg.getBoard());
        buf.writeInteger(msg.getId());
        buf.writeInteger(msg.getPrograms().size());
        for (ProgramsListMessage.Program program : msg.getPrograms())
        {
            program.encode(buf);
        }
    }
    
}
