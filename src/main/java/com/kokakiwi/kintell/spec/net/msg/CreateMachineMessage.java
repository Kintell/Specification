package com.kokakiwi.kintell.spec.net.msg;

public class CreateMachineMessage extends Message
{
    private String id;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
}
