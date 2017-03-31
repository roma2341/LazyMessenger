package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity(name="user_profile")
public class UserProfile  {
    public UserProfile(){

    }

    public UserProfile(String phoneNumber, String localeCode, String deviceId){
    this.phoneNumber = phoneNumber;
    this.localeCode = localeCode;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @OneToOne
    UserProfileSettings settings;

    @OneToOne
    UserProfileStatus status;

    @OneToMany(mappedBy="author")
    List<UserMessage> messages;

    @OneToMany(mappedBy="owner")
    List<UserDevice> devices;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String localeCode;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getId() {
        return id;
    }

    public UserProfileSettings getSettings() {
        return settings;
    }

    public UserProfileStatus getStatus() {
        return status;
    }

    public List<UserMessage> getMessages() {
        return null;
    }
}
