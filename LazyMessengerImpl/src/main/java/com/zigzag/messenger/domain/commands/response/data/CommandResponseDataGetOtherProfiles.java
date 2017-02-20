package com.zigzag.messenger.domain.commands.response.data;

import com.zigzag.messenger.API.domain.CommandData;
import com.zigzag.messenger.API.model.Conversation;
import com.zigzag.messenger.API.model.Profile;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
public class CommandResponseDataGetOtherProfiles implements CommandData {
    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setConversations(List<Profile> profiles) {
        this.profiles = profiles;
    }
    public CommandResponseDataGetOtherProfiles(){

    }
    public CommandResponseDataGetOtherProfiles(List<Profile> profiles){
        this.profiles = profiles;
    }

    private List<Profile> profiles;
}
