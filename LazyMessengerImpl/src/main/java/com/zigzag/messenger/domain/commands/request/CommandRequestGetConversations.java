package com.zigzag.messenger.domain.commands.request;

import com.zigzag.messenger.API.domain.CommandRequest;
import com.zigzag.messenger.API.domain.CommandResponse;
import com.zigzag.messenger.domain.commands.request.data.CommandRequestDataGetConversations;
import com.zigzag.messenger.domain.commands.response.CommandResponseGetConversations;

/**
 * Created by zigza on 19.02.2017.
 */
public class CommandRequestGetConversations implements CommandRequest<CommandRequestDataGetConversations> {
   final String command = "get_conversations";
    CommandRequestDataGetConversations data = new CommandRequestDataGetConversations();

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public CommandRequestDataGetConversations getData() {
        return data;
    }

    @Override
    public CommandResponse process() {
        return new CommandResponseGetConversations();
    }
}
