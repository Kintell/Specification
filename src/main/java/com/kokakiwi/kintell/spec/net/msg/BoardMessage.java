package com.kokakiwi.kintell.spec.net.msg;

import com.kokakiwi.kintell.spec.utils.data.DataBuffer;
import com.kokakiwi.kintell.spec.utils.data.DynamicDataBuffer;

public class BoardMessage extends Message
{
    private int        id;
    private String     opcode;
    private DataBuffer data = new DynamicDataBuffer();
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getOpcode()
    {
        return opcode;
    }
    
    public void setOpcode(String opcode)
    {
        this.opcode = opcode;
    }
    
    public DataBuffer getData()
    {
        return data;
    }
    
    public void setData(DataBuffer data)
    {
        this.data = data;
    }
}
