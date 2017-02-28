package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zigza on 16.02.2017.
 */
@Entity(name="user_message")
public class UserMessage{
    public UserMessage(){

    }
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    String body;

    @ManyToOne(targetEntity = UserProfile.class)
    UserProfile author;

    @ManyToOne(targetEntity = UserConversation.class)
    UserConversation conversation;

   private Date dateSended;
   private boolean isActive;

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
    public UserMessage(String body, UserProfile author){
        this.body = body;
        this.author = author;
    }

    public UserProfile getAuthor() {
        return author;
    }

    public Date getDateSended() {
        return dateSended;
    }

    public Boolean isActive() {
        return isActive;
    }

    public UserConversation getConversation() {
        return conversation;
    }
}
