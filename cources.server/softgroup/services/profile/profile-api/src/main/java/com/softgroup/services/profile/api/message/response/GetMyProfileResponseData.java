package com.softgroup.services.profile.api.message.response;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.protocol.ResponseData;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetMyProfileResponseData implements ResponseData {
    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    UserProfile profile;
}
