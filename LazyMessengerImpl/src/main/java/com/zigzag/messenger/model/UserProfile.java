package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.Message;
import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.model.ProfileSettings;
import com.zigzag.messenger.API.model.ProfileStatus;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserProfile implements Profile {
    public UserProfile(){

    }
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne(targetEntity = UserProfileSettings.class)
    ProfileSettings settings;

    @OneToOne(targetEntity = UserProfileStatus.class )
    ProfileStatus status;

    @OneToMany(mappedBy="author",targetEntity = UserMessage.class)
    List<Message> messages;

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

    @Override
    public List<Message> getMessages() {
        return null;
    }
}
