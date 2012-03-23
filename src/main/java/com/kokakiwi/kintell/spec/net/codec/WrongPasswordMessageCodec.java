package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.WrongPasswordMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class WrongPasswordMessageCodec extends
        MessageCodec<WrongPasswordMessage>
{
    
    public WrongPasswordMessageCodec()
    {
        super((byte) 0x11);
    }
    
    @Override
    public WrongPasswordMessage decode(DataBuffer buf)
    {
        return new WrongPasswordMessage();
    }
    
    @Override
    public void encode(DataBuffer buf, WrongPasswordMessage msg)
    {
        
    }
    
}
