package com.kokakiwi.kintell.spec.net.msg;

public class StopMessage extends Message
{
    private String board;
    private int    id;
    
    public String getBoard()
    {
        return board;
    }
    
    public void setBoard(String board)
    {
        this.board = board;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
}
