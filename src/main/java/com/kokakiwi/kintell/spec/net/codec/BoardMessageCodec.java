package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.BoardMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class BoardMessageCodec extends MessageCodec<BoardMessage>
{
    
    public BoardMessageCodec()
    {
        super((byte) 0x04);
    }
    
    @Override
    public BoardMessage decode(DataBuffer buf)
    {
        BoardMessage msg = new BoardMessage();
        
        msg.setId(buf.readInt());
        msg.setOpcode(buf.readString());
        
        msg.setData(buf.readDataBuffer());
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, BoardMessage msg)
    {
        buf.writeInteger(msg.getId());
        buf.writeString(msg.getOpcode());
        
        buf.writeDataBuffer(msg.getData());
    }
    
}
