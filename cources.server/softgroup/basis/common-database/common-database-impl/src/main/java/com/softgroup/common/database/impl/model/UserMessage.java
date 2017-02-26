package com.softgroup.common.database.impl.model;


import com.softgroup.common.database.api.model.Conversation;
import com.softgroup.common.database.api.model.Message;
import com.softgroup.common.database.api.model.Profile;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zigza on 16.02.2017.
 */
@Entity
public class UserMessage implements Message {
    public UserMessage(){

    }
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    String body;

    @ManyToOne(targetEntity = UserProfile.class)
    Profile author;

    @ManyToOne(targetEntity = UserConversation.class)
    Conversation conversation;

   private Date dateSended;
   private boolean isActive;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBody() {
        return body;
    }
    public UserMessage(String body, Profile author){
        this.body = body;
        this.author = author;
    }

    @Override
    public Profile getAuthor() {
        return author;
    }

    @Override
    public Date getDateSended() {
        return dateSended;
    }

    @Override
    public Boolean isActive() {
        return isActive;
    }

    @Override
    public Conversation getConversation() {
        return conversation;
    }
}
