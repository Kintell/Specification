package com.kokakiwi.kintell.spec.net.msg;

public class SendSourceMessage extends Message
{
    private String machine;
    private String program;
    private String source;
    
    public String getMachine()
    {
        return machine;
    }
    
    public void setMachine(String machine)
    {
        this.machine = machine;
    }
    
    public String getProgram()
    {
        return program;
    }
    
    public void setProgram(String program)
    {
        this.program = program;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }
}
