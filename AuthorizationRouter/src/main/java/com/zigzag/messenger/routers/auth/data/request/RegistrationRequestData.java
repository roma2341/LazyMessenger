package com.zigzag.messenger.routers.auth.data.request;

import com.zigzag.messenger.protocol.api.request.data.RequestData;

/**
 * Created by zigza on 25.02.2017.
 */
public class RegistrationRequestData implements RequestData {

    public RegistrationRequestData(){

    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private String phoneNumber;
    private String localeCode;
    private String deviceId;
}
