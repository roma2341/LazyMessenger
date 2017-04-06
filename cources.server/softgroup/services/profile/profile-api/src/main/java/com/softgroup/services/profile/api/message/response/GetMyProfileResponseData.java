package com.softgroup.services.profile.api.message.response;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.dto.entities.UserProfileDTO;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetMyProfileResponseData implements ResponseData {
    public UserProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(UserProfileDTO profile) {
        this.profile = profile;
    }

    UserProfileDTO profile;
}
