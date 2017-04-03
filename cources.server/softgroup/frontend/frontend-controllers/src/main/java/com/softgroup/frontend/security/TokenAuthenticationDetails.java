package com.softgroup.frontend.security;

/**
 * Created by zigza on 02.04.2017.
 */
public class TokenAuthenticationDetails {
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private String deviceId;
}
