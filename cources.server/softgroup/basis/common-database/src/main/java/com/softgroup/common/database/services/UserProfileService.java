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
    public List<UserProfile> getProfiles(List<String> ids){
        return profileRepository.findByIdIn(ids);
    }

    public UserProfile register(String phoneNumber, String localeCode, String deviceId) {
        UserProfile profile = new UserProfile(phoneNumber,localeCode,deviceId);
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
