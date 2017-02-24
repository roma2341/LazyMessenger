package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.ProfileStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by zigza on 21.02.2017.
 */
@Entity
public class UserProfileStatus implements ProfileStatus {
    public UserProfileStatus(){

    }
    @Override
    public Boolean isActive() {
        return isActive;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private UUID id;

    boolean isActive;
}
