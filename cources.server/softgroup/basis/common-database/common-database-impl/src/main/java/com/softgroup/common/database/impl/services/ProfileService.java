package com.softgroup.common.database.impl.services;

import  com.softgroup.common.database.api.model.*;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
public interface ProfileService {
    public List<Profile> getProfiles();
    public Profile register(String phoneNumber, String localeCode, String deviceId);
}
