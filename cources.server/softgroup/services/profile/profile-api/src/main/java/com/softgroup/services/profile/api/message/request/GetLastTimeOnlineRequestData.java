package com.softgroup.services.profile.api.message.request;

import com.softgroup.common.database.model.UserProfile;

import java.util.List;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetLastTimeOnlineRequestData {
    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }

    List<UserProfile> profiles;
}
