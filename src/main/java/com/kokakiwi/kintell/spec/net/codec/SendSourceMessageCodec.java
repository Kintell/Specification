package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.SendSourceMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class SendSourceMessageCodec extends MessageCodec<SendSourceMessage>
{
    
    public SendSourceMessageCodec()
    {
        super((byte) 0x03);
    }
    
    @Override
    public SendSourceMessage decode(DataBuffer buf)
    {
        SendSourceMessage msg = new SendSourceMessage();
        
        msg.setMachine(buf.readString());
        msg.setProgram(buf.readString());
        msg.setSource(buf.readString());
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, SendSourceMessage msg)
    {
        buf.writeString(msg.getMachine());
        buf.writeString(msg.getProgram());
        buf.writeString(msg.getSource());
    }
    
}
