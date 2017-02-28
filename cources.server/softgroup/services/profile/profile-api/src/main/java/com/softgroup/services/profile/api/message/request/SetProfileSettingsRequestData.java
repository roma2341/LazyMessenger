package com.softgroup.services.profile.api.message.request;

import com.softgroup.common.database.model.UserProfileSettings;
import com.softgroup.common.protocol.RequestData;

/**
 * Created by zigza on 28.02.2017.
 */
public class SetProfileSettingsRequestData implements RequestData {
    public UserProfileSettings getProfileSettings() {
        return profileSettings;
    }

    public void setProfileSettings(UserProfileSettings profileSettings) {
        this.profileSettings = profileSettings;
    }

    UserProfileSettings profileSettings;
}
