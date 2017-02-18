package com.zigzag.messenger.API.model;

import java.util.UUID;

/**
 * Created by zigza on 15.02.2017.
 */
public interface Profile {
    public UUID getId();
    public ProfileSettings getSettings();
    public ProfileStatus getStatus();
}
