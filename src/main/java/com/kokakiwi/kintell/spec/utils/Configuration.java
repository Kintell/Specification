package com.kokakiwi.kintell.spec.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

public class Configuration
{
    private final Map<String, Object> config = new HashMap<String, Object>();
    
    public Configuration()
    {
        instance = this;
    }
    
    public boolean load(File file)
    {
        final String ext = file.getName().substring(
                file.getName().lastIndexOf(".") + 1);
        String type;
        if (ext.equals("yml"))
        {
            type = "yaml";
        }
        else if (ext.equals("xml"))
        {
            type = "xml";
        }
        else
        {
            type = "";
        }
        try
        {
            return load(new FileInputStream(file), type);
        }
        catch (final FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean load(InputStream inputStream)
    {
        try
        {
            return load(inputStream, "");
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public boolean load(InputStream inputFile, String type) throws Exception
    {
        if (type.equalsIgnoreCase("yaml"))
        {
            final Yaml yamlParser = new Yaml();
            final Map<String, Object> data = (Map<String, Object>) yamlParser
                    .load(inputFile);
            if (data != null)
            {
                merge(data, config);
            }
        }
        else
        {
            final Properties props = new Properties();
            
            try
            {
                props.load(inputFile);
            }
            catch (final IOException e)
            {
                e.printStackTrace();
                return false;
            }
            
            for (final Object key : props.stringPropertyNames())
            {
                final String name = key.toString();
                final String value = props.getProperty(name);
                
                config.put(name, value);
            }
        }
        
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public void merge(Map<String, Object> from, Map<String, Object> to)
    {
        for (final String key : from.keySet())
        {
            if (to.get(key) == null)
            {
                to.put(key, from.get(key));
            }
            else
            {
                if (to.get(key) instanceof Map)
                {
                    merge((Map<String, Object>) from.get(key),
                            (Map<String, Object>) to.get(key));
                }
                else
                {
                    to.put(key, from.get(key));
                }
            }
        }
    }
    
    public void save(File file) throws IOException
    {
        Yaml yaml = new Yaml();
        String data = yaml.dump(config);
        IOUtils.write(data, new FileOutputStream(file));
    }
    
    public void set(String name, Object value)
    {
        config.put(name.toLowerCase(), value);
    }
    
    public String getString(String name)
    {
        return (String) get(name);
    }
    
    @SuppressWarnings("unchecked")
    public List<Object> getList(String name)
    {
        return (List<Object>) get(name);
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getStringList(String name)
    {
        return (List<String>) get(name);
    }
    
    @SuppressWarnings("unchecked")
    public Map<String, Object> getNode(String name)
    {
        return (Map<String, Object>) get(name);
    }
    
    public boolean getBoolean(String name)
    {
        return (Boolean) (get(name) == null ? false : get(name));
    }
    
    public int getInteger(String name)
    {
        return (Integer) get(name);
    }
    
    @SuppressWarnings("unchecked")
    public Object get(String nodeName)
    {
        if (nodeName.contains("."))
        {
            final String[] nodes = nodeName.split("\\.");
            Object currentNode = null;
            
            for (final String node : nodes)
            {
                if (currentNode == null)
                {
                    currentNode = config.get(node);
                }
                else
                {
                    if (currentNode instanceof Map)
                    {
                        currentNode = ((Map<String, Object>) currentNode)
                                .get(node);
                    }
                    else
                    {
                        break;
                    }
                }
            }
            
            return currentNode;
        }
        else
        {
            return config.get(nodeName.toLowerCase());
        }
    }
    
    public void reset()
    {
        config.clear();
    }
    
    private static Configuration instance;
    
    public static Configuration getInstance()
    {
        if (instance == null)
        {
            instance = new Configuration();
        }
        return instance;
    }
}
