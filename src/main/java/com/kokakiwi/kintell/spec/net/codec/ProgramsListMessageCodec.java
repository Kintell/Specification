package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.ProgramsListMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class ProgramsListMessageCodec extends MessageCodec<ProgramsListMessage>
{
    
    public ProgramsListMessageCodec()
    {
        super((byte) 0x07);
    }
    
    @Override
    public ProgramsListMessage decode(DataBuffer buf)
    {
        ProgramsListMessage msg = new ProgramsListMessage();
        
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
    public void encode(DataBuffer buf, ProgramsListMessage msg)
    {
        buf.writeInteger(msg.getPrograms().size());
        for (ProgramsListMessage.Program program : msg.getPrograms())
        {
            program.encode(buf);
        }
    }
    
}
