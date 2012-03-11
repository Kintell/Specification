package com.kokakiwi.kintell.spec.net.msg;

import java.util.LinkedList;
import java.util.List;

import com.kokakiwi.kintell.spec.utils.data.DataBuffer;
import com.kokakiwi.kintell.spec.utils.data.Encodable;

public class ProgramsListMessage extends Message
{
    private List<Program> programs = new LinkedList<Program>();
    
    public List<Program> getPrograms()
    {
        return programs;
    }
    
    public void setPrograms(List<Program> programs)
    {
        this.programs = programs;
    }
    
    public static class Program implements Encodable
    {
        private String user;
        private String machine;
        private String id;
        private String name;
        
        public String getUser()
        {
            return user;
        }
        
        public void setUser(String user)
        {
            this.user = user;
        }
        
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
        
        public void encode(DataBuffer buf)
        {
            buf.writeString(user);
            buf.writeString(machine);
            buf.writeString(id);
            buf.writeString(name);
        }
        
        public void decode(DataBuffer buf)
        {
            user = buf.readString();
            machine = buf.readString();
            id = buf.readString();
            name = buf.readString();
        }
        
        public String toString()
        {
            return name;
        }
    }
}
