package com.zigzag.messenger.database.services;

import com.zigzag.messenger.API.database.services.ProfileService;
import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.repository.ProfileRepository;
import com.zigzag.messenger.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
public class UserProfileService implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public UserProfile register(String phoneNumber, String localeCode, String deviceId) {
        UserProfile profile = new UserProfile(phoneNumber,localeCode,deviceId);
        profileRepository.save(profile);
        return profile;
    }

}
