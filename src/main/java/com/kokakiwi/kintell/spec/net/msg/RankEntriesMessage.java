package com.kokakiwi.kintell.spec.net.msg;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;
import com.kokakiwi.kintell.spec.utils.data.Encodable;

public class RankEntriesMessage extends Message
{
    private Map<String, List<Rank>> ranks = Maps.newLinkedHashMap();
    
    public Map<String, List<Rank>> getRanks()
    {
        return ranks;
    }
    
    public void setRanks(Map<String, List<Rank>> ranks)
    {
        this.ranks = ranks;
    }
    
    public static class Rank implements Encodable
    {
        private String program;
        private int    points;
        
        public String getProgram()
        {
            return program;
        }
        
        public void setProgram(String program)
        {
            this.program = program;
        }
        
        public int getPoints()
        {
            return points;
        }
        
        public void setPoints(int points)
        {
            this.points = points;
        }
        
        public void encode(DataBuffer buf)
        {
            buf.writeString(program);
            buf.writeInteger(points);
        }
        
        public void decode(DataBuffer buf)
        {
            program = buf.readString();
            points = buf.readInt();
        }
    }
}
