package com.softgroup.services.profile.api.message.request;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetOtherProfilesRequestData implements RequestData {
    public List<String> getUserId() {
        return userId;
    }

    public void setUserId(List<String> userId) {
        this.userId = userId;
    }

    List<String> userId;
}
