package com.softgroup.common.database.services;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.repository.UserProfileRepository;
import com.softgroup.common.database.repository.UserProfileSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Service
public class UserProfileSettingsService {
    @Autowired
    UserProfileSettingsRepository settingsRepository;

}
