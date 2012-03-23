package com.kokakiwi.kintell.spec.net.msg;

public class ConnectMessage extends Message
{
    private String pseudo;
    private String password;
    
    public String getPseudo()
    {
        return pseudo;
    }
    
    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
