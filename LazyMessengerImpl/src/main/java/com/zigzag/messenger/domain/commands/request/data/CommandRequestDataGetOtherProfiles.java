package com.zigzag.messenger.domain.commands.request.data;

import com.zigzag.messenger.API.domain.CommandData;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 19.02.2017.
 */
public class CommandRequestDataGetOtherProfiles implements CommandData {
    public List<UUID> getProfiles() {
        return profilesIds;
    }

    public void setConversationIds(List<UUID> profilesIds) {
        this.profilesIds = profilesIds;
    }
    public CommandRequestDataGetOtherProfiles(){

    }
    public CommandRequestDataGetOtherProfiles(List<UUID> profilesIds){
       this.profilesIds = profilesIds;
    }

    List<UUID> profilesIds;
}
