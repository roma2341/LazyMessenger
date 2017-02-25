package com.softgroup.common.database.api.repository;

import com.softgroup.common.database.api.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
public interface ProfileRepository extends CrudRepository<Profile,UUID> {
    public List<Profile> findAll();
}
