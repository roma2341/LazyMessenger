package com.softgroup.common.database.impl.model;

import com.zigzag.messenger.API.model.Message;
import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.model.ProfileSettings;
import com.zigzag.messenger.API.model.ProfileStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserProfile implements Profile {
    public UserProfile(){

    }

    public UserProfile(String phoneNumber, String localeCode, String deviceId){
    this.phoneNumber = phoneNumber;
    this.localeCode = localeCode;
    this.deviceId = deviceId;
    }

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @OneToOne(targetEntity = UserProfileSettings.class)
    ProfileSettings settings;

    @OneToOne(targetEntity = UserProfileStatus.class )
    ProfileStatus status;

    @OneToMany(mappedBy="author",targetEntity = UserMessage.class)
    List<Message> messages;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String localeCode;

    @Column(nullable = false)
    String deviceId;


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

    @Override
    public String getId() {
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
