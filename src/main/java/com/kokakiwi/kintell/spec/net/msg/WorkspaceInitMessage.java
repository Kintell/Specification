package com.kokakiwi.kintell.spec.net.msg;

import java.util.LinkedList;
import java.util.List;

import com.kokakiwi.kintell.spec.utils.data.DataBuffer;
import com.kokakiwi.kintell.spec.utils.data.Encodable;

public class WorkspaceInitMessage extends Message
{
    private List<ContentType> contentTypes = new LinkedList<ContentType>();
    private List<Machine>     machines     = new LinkedList<Machine>();
    
    public List<ContentType> getContentTypes()
    {
        return contentTypes;
    }
    
    public void setContentTypes(List<ContentType> contentTypes)
    {
        this.contentTypes = contentTypes;
    }
    
    public List<Machine> getMachines()
    {
        return machines;
    }
    
    public void setMachines(List<Machine> machines)
    {
        this.machines = machines;
    }
    
    public static class ContentType implements Encodable
    {
        private String name;
        private String id;
        private String contentType;
        
        public String getName()
        {
            return name;
        }
        
        public void setName(String name)
        {
            this.name = name;
        }
        
        public String getId()
        {
            return id;
        }
        
        public void setId(String id)
        {
            this.id = id;
        }
        
        public String getContentType()
        {
            return contentType;
        }
        
        public void setContentType(String contentType)
        {
            this.contentType = contentType;
        }
        
        public void encode(DataBuffer buf)
        {
            buf.writeString(id);
            buf.writeString(name);
            buf.writeString(contentType);
        }
        
        public void decode(DataBuffer buf)
        {
            id = buf.readString();
            name = buf.readString();
            contentType = buf.readString();
        }
        
        public String toString()
        {
            return name;
        }
        
    }
    
    public static class Machine implements Encodable
    {
        private String        id;
        private List<Program> programs = new LinkedList<Program>();
        
        public String getId()
        {
            return id;
        }
        
        public void setId(String id)
        {
            this.id = id;
        }
        
        public List<Program> getPrograms()
        {
            return programs;
        }
        
        public void setPrograms(List<Program> programs)
        {
            this.programs = programs;
        }
        
        public void encode(DataBuffer buf)
        {
            buf.writeString(id);
            buf.writeInteger(programs.size());
            for (Program program : programs)
            {
                program.encode(buf);
            }
        }
        
        public void decode(DataBuffer buf)
        {
            id = buf.readString();
            int size = buf.readInt();
            for (int i = 0; i < size; i++)
            {
                Program program = new Program();
                program.decode(buf);
                programs.add(program);
            }
        }
        
    }
    
    public static class Program implements Encodable
    {
        private String id;
        private String name;
        private String contentType;
        private String source;
        
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
        
        public String getContentType()
        {
            return contentType;
        }
        
        public void setContentType(String contentType)
        {
            this.contentType = contentType;
        }
        
        public String getSource()
        {
            return source;
        }
        
        public void setSource(String source)
        {
            this.source = source;
        }
        
        public void encode(DataBuffer buf)
        {
            buf.writeString(id);
            buf.writeString(name);
            buf.writeString(contentType);
            buf.writeString(source);
        }
        
        public void decode(DataBuffer buf)
        {
            id = buf.readString();
            name = buf.readString();
            contentType = buf.readString();
            source = buf.readString();
        }
        
    }
}
