package com.kokakiwi.kintell.spec.plugin;

import com.kokakiwi.kintell.spec.utils.Configuration;
import com.kokakiwi.kintell.spec.utils.Version;

public class PluginDescriptionFile
{
    private String  name;
    private Version version;
    private String  main;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Version getVersion()
    {
        return version;
    }
    
    public void setVersion(Version version)
    {
        this.version = version;
    }
    
    public String getMain()
    {
        return main;
    }
    
    public void setMain(String main)
    {
        this.main = main;
    }
    
    public static PluginDescriptionFile fromYaml(Configuration conf)
    {
        PluginDescriptionFile pdf = new PluginDescriptionFile();
        
        pdf.setName(conf.getString("name"));
        pdf.setVersion(Version.parseString(conf.getString("version")));
        pdf.setMain(conf.getString("main"));
        
        return pdf;
    }
}
