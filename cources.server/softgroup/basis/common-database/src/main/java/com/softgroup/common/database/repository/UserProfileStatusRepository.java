package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.model.UserProfileStatus;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
public interface UserProfileStatusRepository extends CommonOperationsRepository<UserProfileStatus,String> {

}
