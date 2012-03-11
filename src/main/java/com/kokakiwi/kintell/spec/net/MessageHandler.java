package com.kokakiwi.kintell.spec.net;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.kokakiwi.kintell.spec.net.msg.Message;

/**
 * @author Koka El Kiwi
 * 
 */
public abstract class MessageHandler<T extends Message>
{
    @SuppressWarnings("unchecked")
    public boolean handle(ChannelHandlerContext ctx, MessageEvent e)
    {
        T msg = (T) e.getMessage();
        return handle(ctx, e, msg);
    }
    
    public abstract boolean handle(ChannelHandlerContext ctx, MessageEvent e,
            T msg);
}
