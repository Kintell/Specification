package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.StopMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class StopMessageCodec extends MessageCodec<StopMessage>
{
    
    public StopMessageCodec()
    {
        super((byte) 0x09);
    }
    
    @Override
    public StopMessage decode(DataBuffer buf)
    {
        StopMessage msg = new StopMessage();
        
        msg.setBoard(buf.readString());
        msg.setId(buf.readInt());
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, StopMessage msg)
    {
        buf.writeString(msg.getBoard());
        buf.writeInteger(msg.getId());
    }
    
}
