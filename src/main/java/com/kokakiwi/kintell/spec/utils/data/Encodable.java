package com.kokakiwi.kintell.spec.utils.data;

public interface Encodable
{
    public void encode(DataBuffer buf);
    
    public void decode(DataBuffer buf);
}
