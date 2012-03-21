package com.kokakiwi.kintell.spec.net;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

public class CodecFrameDecoder extends FrameDecoder
{
    
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel,
            ChannelBuffer buf) throws Exception
    {
        ChannelBuffer frame = null;
        
        if (buf.readableBytes() >= 4)
        {
            buf.markReaderIndex();
            int size = buf.readInt();
            if (buf.readableBytes() < size)
            {
                buf.resetReaderIndex();
            }
            else
            {
                frame = buf.readBytes(size);
            }
        }
        
        return frame;
    }
}
