package com.softgroup.common.protocol;

/**
 * Created by zigza on 08.03.2017.
 */
public class RoutedData {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private String userId;
    private String deviceId;
}
