package com.kokakiwi.kintell.spec.net.msg;

public class ConnectMessage extends Message
{
    private String pseudo;
    
    public String getPseudo()
    {
        return pseudo;
    }
    
    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }
}
