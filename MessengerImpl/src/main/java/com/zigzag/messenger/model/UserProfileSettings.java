package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.ProfileSettings;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by zigza on 21.02.2017.
 */
@Entity
public class UserProfileSettings implements ProfileSettings {
    public UserProfileSettings(){

    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public String getId() {
        return id;
    }

    String language;
    String nickName;
    Integer age;
    String avatar;
    String sex;

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

}
