package com.zigzag.messenger.domain.commands.response;

import com.zigzag.messenger.API.domain.CommandResponse;
import com.zigzag.messenger.domain.commands.response.data.CommandResponseDataGetConversations;
import com.zigzag.messenger.domain.commands.response.data.CommandResponseDataGetOtherProfiles;

/**
 * Created by zigza on 20.02.2017.
 */
public class CommandResponseGetOtherProfiles implements CommandResponse<CommandResponseDataGetOtherProfiles> {
    @Override
    public String getCommand() {
        return "get_conversations";
    }

    @Override
    public CommandResponseDataGetOtherProfiles getData() {
        return data;
    }
    CommandResponseDataGetOtherProfiles data;
}
