package com.zigzag.messenger.domain.commands.response.data;

import com.zigzag.messenger.API.domain.CommandData;
import com.zigzag.messenger.API.model.Conversation;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
public class CommandResponseDataGetConversations implements CommandData {
    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
    public CommandResponseDataGetConversations(){

    }
    public CommandResponseDataGetConversations(List<Conversation> conversations){
        this.conversations = conversations;
    }

    List<Conversation> conversations;
}
