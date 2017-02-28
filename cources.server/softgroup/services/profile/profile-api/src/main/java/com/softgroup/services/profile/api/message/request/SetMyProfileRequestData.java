package com.softgroup.services.profile.api.message.request;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.protocol.RequestData;

/**
 * Created by zigza on 28.02.2017.
 */
public class SetMyProfileRequestData implements RequestData {
    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    UserProfile profile;
}
