package com.softgroup.services.profile.api.message.request;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetLastTimeOnlineRequestData implements RequestData {
    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }

    List<UserProfile> profiles;
}
