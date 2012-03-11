package com.kokakiwi.kintell.spec.net.codec;

import com.kokakiwi.kintell.spec.net.msg.WorkspaceInitMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class WorkspaceInitMessageCodec extends
        MessageCodec<WorkspaceInitMessage>
{
    
    public WorkspaceInitMessageCodec()
    {
        super((byte) 0x02);
    }
    
    @Override
    public WorkspaceInitMessage decode(DataBuffer buf)
    {
        WorkspaceInitMessage msg = new WorkspaceInitMessage();
        
        int size = buf.readInt();
        for (int i = 0; i < size; i++)
        {
            WorkspaceInitMessage.ContentType contentType = new WorkspaceInitMessage.ContentType();
            contentType.decode(buf);
            msg.getContentTypes().add(contentType);
        }
        
        size = buf.readInt();
        for (int i = 0; i < size; i++)
        {
            WorkspaceInitMessage.Machine machine = new WorkspaceInitMessage.Machine();
            machine.decode(buf);
            msg.getMachines().add(machine);
        }
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, WorkspaceInitMessage msg)
    {
        buf.writeInteger(msg.getContentTypes().size());
        for (WorkspaceInitMessage.ContentType contentType : msg
                .getContentTypes())
        {
            contentType.encode(buf);
        }
        
        buf.writeInteger(msg.getMachines().size());
        for (WorkspaceInitMessage.Machine machine : msg.getMachines())
        {
            machine.encode(buf);
        }
    }
    
}
