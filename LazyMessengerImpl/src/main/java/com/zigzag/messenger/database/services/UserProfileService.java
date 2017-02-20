package com.zigzag.messenger.database.services;

import com.zigzag.messenger.API.database.services.ProfileService;
import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.repository.ProfileRepository;
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
}
