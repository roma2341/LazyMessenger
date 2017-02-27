package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zigza on 21.02.2017.
 */
@Entity(name="user_profile_settings")
public class UserProfileSettings {
    public UserProfileSettings(){

    }

    public String getLanguage() {
        return language;
    }

    public String getNickName() {
        return nickName;
    }

    public Integer getAge() {
        return age;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getSex() {
        return sex;
    }

    public String getId() {
        return id;
    }

    String language;
    String nickName;
    Integer age;
    String avatar;
    String sex;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

}
