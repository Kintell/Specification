package com.kokakiwi.kintell.spec.plugin;

public abstract class Plugin
{
    protected PluginDescriptionFile description = null;
    protected PluginLoader          loader      = null;
    
    public final void init(PluginDescriptionFile description,
            PluginLoader loader)
    {
        this.description = description;
        this.loader = loader;
    }
    
    public final PluginDescriptionFile getDescription()
    {
        return description;
    }
    
    public final PluginLoader getLoader()
    {
        return loader;
    }
    
    public void onLoad()
    {
        
    }
    
    public void onEnable()
    {
        
    }
    
    public void onDisable()
    {
        
    }
}
