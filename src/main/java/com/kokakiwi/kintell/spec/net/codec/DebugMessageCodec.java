package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.DebugMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class DebugMessageCodec extends MessageCodec<DebugMessage>
{
    
    public DebugMessageCodec()
    {
        super((byte) 0x10);
    }
    
    @Override
    public DebugMessage decode(DataBuffer buf)
    {
        DebugMessage msg = new DebugMessage();
        
        int size = buf.readInt();
        for (int i = 0; i < size; i++)
        {
            String message = buf.readString();
            msg.getMessages().add(message);
        }
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, DebugMessage msg)
    {
        buf.writeInteger(msg.getMessages().size());
        for (String message : msg.getMessages())
        {
            buf.writeString(message);
        }
    }
    
}
