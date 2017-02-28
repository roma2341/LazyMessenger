package com.softgroup.common.database.services;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Service
public class UserProfileService {
    @Autowired
    UserProfileRepository profileRepository;

    public List<UserProfile> getProfiles() {
        return profileRepository.findAll();
    }

    public UserProfile register(String phoneNumber, String localeCode, String deviceId) {
        UserProfile profile = new UserProfile(phoneNumber,localeCode,deviceId);
        profileRepository.save(profile);
        return profile;
    }

}
