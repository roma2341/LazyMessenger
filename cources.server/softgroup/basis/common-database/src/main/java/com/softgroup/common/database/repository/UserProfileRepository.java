package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
public interface UserProfileRepository extends CommonOperationsRepository<UserProfile,String> {

    @Query("select p from user_profile p where p.phoneNumber in (select c.phoneNumber from user_contact c where c.id=?1)")
    public List<UserProfile> findContactProfiles(String userId);
}
