package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
public interface UserProfileRepository extends CrudRepository<UserProfile,UUID> {

    public List<UserProfile> findAll();
}
