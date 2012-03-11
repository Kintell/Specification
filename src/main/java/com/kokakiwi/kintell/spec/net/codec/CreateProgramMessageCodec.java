package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.CreateProgramMessage;
import com.kokakiwi.kintell.spec.net.msg.WorkspaceInitMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class CreateProgramMessageCodec extends
        MessageCodec<CreateProgramMessage>
{
    
    public CreateProgramMessageCodec()
    {
        super((byte) 0x06);
    }
    
    @Override
    public CreateProgramMessage decode(DataBuffer buf)
    {
        CreateProgramMessage msg = new CreateProgramMessage();
        
        msg.setMachine(buf.readString());
        msg.setId(buf.readString());
        msg.setName(buf.readString());
        WorkspaceInitMessage.ContentType contentType = new WorkspaceInitMessage.ContentType();
        contentType.decode(buf);
        msg.setContentType(contentType);
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, CreateProgramMessage msg)
    {
        buf.writeString(msg.getMachine());
        buf.writeString(msg.getId());
        buf.writeString(msg.getName());
        msg.getContentType().encode(buf);
    }
    
}
