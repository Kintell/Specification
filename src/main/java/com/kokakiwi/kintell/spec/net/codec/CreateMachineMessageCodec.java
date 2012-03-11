package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.CreateMachineMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class CreateMachineMessageCodec extends
        MessageCodec<CreateMachineMessage>
{
    
    public CreateMachineMessageCodec()
    {
        super((byte) 0x05);
    }
    
    @Override
    public CreateMachineMessage decode(DataBuffer buf)
    {
        CreateMachineMessage msg = new CreateMachineMessage();
        
        msg.setId(buf.readString());
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, CreateMachineMessage msg)
    {
        buf.writeString(msg.getId());
    }
    
}
