package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.Message;
import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.model.Conversation;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zigza on 16.02.2017.
 */
@Entity
public class UserMessage implements Message {
    public UserMessage(){

    }
    @Id
    @GeneratedValue
    private UUID id;

    String body;

    @ManyToOne(targetEntity = UserProfile.class)
    Profile author;

    @ManyToOne(targetEntity = UserConversation.class)
    Conversation conversation;

   private Date dateSended;
   private boolean isActive;

    @Override
    public UUID getId() {
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
