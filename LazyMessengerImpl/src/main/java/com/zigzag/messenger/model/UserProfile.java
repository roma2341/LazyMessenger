package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.model.ProfileSettings;
import com.zigzag.messenger.API.model.ProfileStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserProfile implements Profile {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    ProfileSettings settings;

    @OneToOne
    ProfileStatus status;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public ProfileSettings getSettings() {
        return settings;
    }

    @Override
    public ProfileStatus getStatus() {
        return status;
    }
}
