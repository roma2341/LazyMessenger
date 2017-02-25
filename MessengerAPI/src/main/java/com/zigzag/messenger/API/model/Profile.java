package com.zigzag.messenger.API.model;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 15.02.2017.
 */
public interface Profile {
    public String getId();
    public ProfileSettings getSettings();
    public ProfileStatus getStatus();
    public List<Message> getMessages();
    public String getPhoneNumber();
    public void setPhoneNumber(String phoneNumber);
    public String getLocaleCode();
    public void setLocaleCode(String localeCode);
    public String getDeviceId();
    public void setDeviceId(String deviceId);
}
