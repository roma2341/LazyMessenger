package com.softgroup.common.database.impl.model;

import com.zigzag.messenger.API.model.ConversationDetails;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserConversationDetails implements ConversationDetails {
    public UserConversationDetails(){

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