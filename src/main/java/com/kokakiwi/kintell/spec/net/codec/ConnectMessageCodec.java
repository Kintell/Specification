package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.ConnectMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class ConnectMessageCodec extends MessageCodec<ConnectMessage>
{
    public ConnectMessageCodec()
    {
        super((byte) 0x01);
    }
    
    @Override
    public ConnectMessage decode(DataBuffer buf)
    {
        ConnectMessage msg = new ConnectMessage();
        
        msg.setPseudo(buf.readString());
        msg.setPassword(buf.readString());
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, ConnectMessage msg)
    {
        buf.writeString(msg.getPseudo());
        buf.writeString(msg.getPassword());
    }
    
}
