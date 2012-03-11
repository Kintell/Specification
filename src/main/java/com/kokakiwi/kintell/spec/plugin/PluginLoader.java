package com.kokakiwi.kintell.spec.plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader
{
    private final File     file;
    private URLClassLoader classLoader;
    
    public PluginLoader(File file)
    {
        this.file = file;
    }
    
    public void load() throws Exception
    {
        URL[] urls = new URL[1];
        urls[0] = file.toURI().toURL();
        
        classLoader = new URLClassLoader(urls,
                PluginLoader.class.getClassLoader());
    }
    
    public File getFile()
    {
        return file;
    }
    
    public URLClassLoader getClassLoader()
    {
        return classLoader;
    }
    
    public Class<?> loadClass(String name) throws ClassNotFoundException
    {
        return classLoader.loadClass(name);
    }
}
