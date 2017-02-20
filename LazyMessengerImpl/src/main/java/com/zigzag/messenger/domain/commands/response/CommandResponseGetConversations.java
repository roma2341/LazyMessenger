package com.zigzag.messenger.domain.commands.response;

import com.zigzag.messenger.API.domain.CommandResponse;
import com.zigzag.messenger.domain.commands.request.data.CommandRequestDataGetConversations;
import com.zigzag.messenger.domain.commands.response.data.CommandResponseDataGetConversations;

/**
 * Created by zigza on 20.02.2017.
 */
public class CommandResponseGetConversations implements CommandResponse<CommandResponseDataGetConversations> {
    @Override
    public String getCommand() {
        return "get_conversations";
    }

    @Override
    public CommandResponseDataGetConversations getData() {
        return data;
    }
    CommandResponseDataGetConversations data;
}
