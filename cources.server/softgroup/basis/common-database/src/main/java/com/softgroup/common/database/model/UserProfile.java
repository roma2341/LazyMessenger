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
    this.deviceId = deviceId;
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

    @OneToMany(mappedBy="author",targetEntity = UserMessage.class)
    List<UserMessage> messages;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String localeCode;

    @Column(nullable = false)
    String deviceId;

    @OneToMany(mappedBy="userProfile")
    List<UserDevice> devices;


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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
