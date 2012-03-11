package com.kokakiwi.kintell.spec.plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.google.common.collect.Maps;
import com.kokakiwi.kintell.spec.utils.Configuration;

public abstract class PluginsManager<T extends Plugin>
{
    private final Map<String, T> loaded     = Maps.newLinkedHashMap();
    private File                 pluginsDir = null;
    
    public T getPlugin(String name)
    {
        return loaded.get(name);
    }
    
    public void loadPlugins() throws Exception
    {
        if (pluginsDir != null)
        {
            if (!pluginsDir.exists())
            {
                pluginsDir.mkdirs();
            }
            loadPlugins(pluginsDir);
        }
    }
    
    public void loadPlugins(File dir) throws Exception
    {
        if (dir.exists() && dir.isDirectory())
        {
            for (String fileName : dir.list(new FilenameFilter() {
                
                public boolean accept(File dir, String name)
                {
                    return name.endsWith(".jar");
                }
            }))
            {
                File file = new File(dir, fileName);
                loadPlugin(file);
            }
        }
    }
    
    public T loadPlugin(File file) throws Exception
    {
        T plugin = null;
        
        JarFile jar = new JarFile(file);
        JarEntry definitionFile = jar.getJarEntry("plugin.yml");
        if (definitionFile != null)
        {
            Configuration definitionConf = new Configuration();
            definitionConf.load(jar.getInputStream(definitionFile), "yaml");
            PluginDescriptionFile pdf = PluginDescriptionFile
                    .fromYaml(definitionConf);
            
            PluginLoader loader = new PluginLoader(file);
            loader.load();
            
            plugin = createPlugin(pdf, loader);
            registerPlugin(plugin, pdf, loader);
        }
        
        return plugin;
    }
    
    public void registerPlugin(T plugin, PluginDescriptionFile pdf,
            PluginLoader loader)
    {
        plugin.init(pdf, loader);
        plugin.onLoad();
        
        loaded.put(pdf.getName(), plugin);
    }
    
    public void enablePlugins()
    {
        for (T plugin : loaded.values())
        {
            plugin.onEnable();
        }
    }
    
    public void disablePlugins()
    {
        for (T plugin : loaded.values())
        {
            plugin.onDisable();
        }
    }
    
    public Map<String, T> getPlugins()
    {
        return loaded;
    }
    
    public File getPluginsDir()
    {
        return pluginsDir;
    }
    
    public void setPluginsDir(File pluginsDir)
    {
        this.pluginsDir = pluginsDir;
    }
    
    public abstract T createPlugin(PluginDescriptionFile pdf,
            PluginLoader loader);
}
