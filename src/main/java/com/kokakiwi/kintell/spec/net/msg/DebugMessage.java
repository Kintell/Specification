package com.kokakiwi.kintell.spec.net.msg;

import java.util.List;

import com.google.common.collect.Lists;

public class DebugMessage extends Message
{
    private List<String> messages = Lists.newLinkedList();
    
    public List<String> getMessages()
    {
        return messages;
    }
    
    public void setMessages(List<String> messages)
    {
        this.messages = messages;
    }
}
