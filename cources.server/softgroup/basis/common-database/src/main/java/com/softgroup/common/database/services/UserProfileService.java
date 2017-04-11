package com.softgroup.common.database.services;

import com.softgroup.common.database.model.UserDevice;
import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.model.UserProfileSettings;
import com.softgroup.common.database.repository.UserDeviceRepository;
import com.softgroup.common.database.repository.UserProfileRepository;
import com.softgroup.common.database.repository.UserProfileSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Service
@Transactional
public class UserProfileService {
    @Autowired
    UserProfileRepository profileRepository;
    @Autowired
    UserProfileSettingsRepository userProfileSettingsRepository;
    @Autowired
    UserDeviceRepository deviceRepository;

    public List<UserProfile> getProfiles() {
        return profileRepository.findAll();
    }
    public List<UserProfile> getProfiles(List<String> ids){
        return profileRepository.findByIdIn(ids);
    }

    public UserProfile register(String phoneNumber, String localeCode, String deviceId) {
        UserProfile profile = new UserProfile(phoneNumber,localeCode,deviceId);

        UserProfileSettings settings = new UserProfileSettings();
        List<UserDevice> devicesList = new ArrayList<UserDevice>();
        UserDevice initialDevice = new UserDevice();
        devicesList.add(initialDevice);
        initialDevice.setId(deviceId);
        settings = userProfileSettingsRepository.save(settings);
        devicesList = (List<UserDevice>)deviceRepository.save(devicesList);
        profile.setSettings(settings);
        profile.setDevices(devicesList);
        profile.setCreateDateTime(System.currentTimeMillis());
        profileRepository.save(profile);

        return profile;
    }
    public UserProfile getProfile(String id){
        return profileRepository.findOne(id);
    }

    public List<UserProfile> getContactProfiles(String userId){
        return profileRepository.findContactProfiles(userId);
    }

}
