package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.model.UserProfileSettings;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
public interface UserProfileSettingsRepository extends CommonOperationsRepository<UserProfileSettings,String> {


}
