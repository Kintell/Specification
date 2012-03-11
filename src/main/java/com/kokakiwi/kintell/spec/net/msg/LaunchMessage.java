package com.kokakiwi.kintell.spec.net.msg;

import java.util.LinkedList;
import java.util.List;

public class LaunchMessage extends Message
{
    private String                            board;
    private int                               id       = 0;
    private List<ProgramsListMessage.Program> programs = new LinkedList<ProgramsListMessage.Program>();
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getBoard()
    {
        return board;
    }
    
    public void setBoard(String board)
    {
        this.board = board;
    }
    
    public List<ProgramsListMessage.Program> getPrograms()
    {
        return programs;
    }
    
    public void setPrograms(List<ProgramsListMessage.Program> programs)
    {
        this.programs = programs;
    }
}
