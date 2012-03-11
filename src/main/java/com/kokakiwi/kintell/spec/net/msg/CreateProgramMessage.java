package com.kokakiwi.kintell.spec.net.msg;

public class CreateProgramMessage extends Message
{
    private String                           machine;
    private String                           id;
    private String                           name;
    private WorkspaceInitMessage.ContentType contentType;
    
    public String getMachine()
    {
        return machine;
    }
    
    public void setMachine(String machine)
    {
        this.machine = machine;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public WorkspaceInitMessage.ContentType getContentType()
    {
        return contentType;
    }
    
    public void setContentType(WorkspaceInitMessage.ContentType contentType)
    {
        this.contentType = contentType;
    }
}
