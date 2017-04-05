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
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserProfileSettings getSettings() {
        return settings;
    }

    public void setSettings(UserProfileSettings settings) {
        this.settings = settings;
    }

    public UserProfileStatus getStatus() {
        return status;
    }

    public void setStatus(UserProfileStatus status) {
        this.status = status;
    }

    public List<UserMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<UserMessage> messages) {
        this.messages = messages;
    }

    public List<UserDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<UserDevice> devices) {
        this.devices = devices;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @OneToOne
    UserProfileSettings settings;

    @OneToOne
    UserProfileStatus status;

    @OneToMany(mappedBy="sender")
    List<UserMessage> messages;

    @OneToMany(mappedBy="owner")
    List<UserDevice> devices;

    @Column(nullable = false)
    String phoneNumber;

    @Column(name="name")
    String name;

    @ManyToMany
    List<UserConversationDetails> conversations;

    Long createDateTime;
    Long updateDateTime;


}
