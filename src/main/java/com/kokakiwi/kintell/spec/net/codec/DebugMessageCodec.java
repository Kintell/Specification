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
        
        msg.setMessage(buf.readString());
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, DebugMessage msg)
    {
        buf.writeString(msg.getMessage());
    }
    
}
