package com.kokakiwi.kintell.spec.net.msg;

public class DebugMessage extends Message
{
    private String message;
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
}
