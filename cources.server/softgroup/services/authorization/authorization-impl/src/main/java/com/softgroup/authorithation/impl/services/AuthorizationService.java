package com.softgroup.authorithation.impl.services;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zigza on 06.03.2017.
 */
@Service
public class AuthorizationService {
    @Autowired
    UserProfileService profileService;
    final String TEST_USER_ID = "test";
    public UserProfile getCurrentProfile(){
       return profileService.getProfile(TEST_USER_ID);
    }

}
