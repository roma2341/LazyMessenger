package com.softgroup.services.authorization.api.message.response;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by zigza on 28.02.2017.
 */
public class SmsConfirmResponseData implements ResponseData {
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    String deviceToken;
}