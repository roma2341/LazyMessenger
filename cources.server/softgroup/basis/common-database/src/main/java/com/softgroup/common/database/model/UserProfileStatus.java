package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zigza on 21.02.2017.
 */
@Entity(name="user_profile_status")
public class UserProfileStatus  {
    public UserProfileStatus(){

    }
    public Boolean isActive() {
        return active;
    }

    public String getId() {
        return id;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    boolean active;
}
