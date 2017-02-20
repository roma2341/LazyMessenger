package com.zigzag.messenger.domain.commands.request.data;

import com.zigzag.messenger.API.domain.CommandData;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 19.02.2017.
 */
public class CommandRequestDataGetConversations implements CommandData {
    public List<UUID> getConversationIds() {
        return conversationIds;
    }

    public void setConversationIds(List<UUID> conversationIds) {
        this.conversationIds = conversationIds;
    }
    public CommandRequestDataGetConversations(){

    }
    public CommandRequestDataGetConversations(List<UUID> ids){
       this.conversationIds = ids;
    }

    List<UUID> conversationIds;
}
