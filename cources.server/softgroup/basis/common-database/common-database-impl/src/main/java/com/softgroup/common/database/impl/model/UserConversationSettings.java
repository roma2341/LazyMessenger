package com.softgroup.common.database.impl.model;

import com.softgroup.common.database.api.model.ConversationSettings;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserConversationSettings implements ConversationSettings {
    public UserConversationSettings(){

    }
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    public String getId() {
        return id;
    }
}
