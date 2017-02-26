package com.softgroup.common.database.impl.model;

import com.softgroup.common.database.api.model.ProfileStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zigza on 21.02.2017.
 */
@Entity
public class UserProfileStatus implements ProfileStatus {
    public UserProfileStatus(){

    }
    public Boolean isActive() {
        return isActive;
    }

    public String getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private String id;

    boolean isActive;
}
