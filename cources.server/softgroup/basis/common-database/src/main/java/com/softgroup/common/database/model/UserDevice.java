package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zigza on 30.03.2017.
 */
@Entity
@Table(name = "user_device")
public class UserDevice {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "locale_code")
    private String locale_code;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "update_date_time")
    private Long updateDateTime;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @ManyToOne
    private UserProfile userProfile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocale_code() {
        return locale_code;
    }

    public void setLocale_code(String locale_code) {
        this.locale_code = locale_code;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
