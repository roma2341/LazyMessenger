package com.softgroup.services.profile.api.message.response;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetContactProfilesResponseData implements ResponseData {
    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }

    List<UserProfile> profiles;
}
