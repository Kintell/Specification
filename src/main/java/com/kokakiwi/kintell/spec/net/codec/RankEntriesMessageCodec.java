package com.kokakiwi.kintell.spec.net.codec;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.kokakiwi.kintell.spec.net.msg.RankEntriesMessage;
import com.kokakiwi.kintell.spec.utils.data.DataBuffer;

public class RankEntriesMessageCodec extends MessageCodec<RankEntriesMessage>
{
    
    public RankEntriesMessageCodec()
    {
        super((byte) 0x12);
    }
    
    @Override
    public RankEntriesMessage decode(DataBuffer buf)
    {
        RankEntriesMessage msg = new RankEntriesMessage();
        
        int size = buf.readInt();
        for (int i = 0; i < size; i++)
        {
            String board = buf.readString();
            
            List<RankEntriesMessage.Rank> ranks = Lists.newLinkedList();
            
            int length = buf.readInt();
            for (int j = 0; j < length; j++)
            {
                RankEntriesMessage.Rank rank = new RankEntriesMessage.Rank();
                rank.decode(buf);
                ranks.add(rank);
            }
            
            msg.getRanks().put(board, ranks);
        }
        
        return msg;
    }
    
    @Override
    public void encode(DataBuffer buf, RankEntriesMessage msg)
    {
        buf.writeInteger(msg.getRanks().size());
        for (Map.Entry<String, List<RankEntriesMessage.Rank>> entry : msg
                .getRanks().entrySet())
        {
            buf.writeString(entry.getKey());
            buf.writeInteger(entry.getValue().size());
            for (RankEntriesMessage.Rank rank : entry.getValue())
            {
                rank.encode(buf);
            }
        }
    }
    
}
