package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserConversation implements Conversation {
    public UserConversation(){

    }
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToMany(targetEntity = UserProfile.class)
    private List<Profile> participants;

    @OneToMany(mappedBy = "author",targetEntity=UserMessage.class)
    private List<Message> messages;

    @OneToOne(targetEntity = UserConversation.class)
    private ConversationDetails conversationDetails;

    @OneToOne(targetEntity = UserConversationSettings.class)
    private ConversationSettings settings;

    private Date dateCreated;

    private String title;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public List<Profile> getParticipants() {
        return participants;
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public ConversationDetails getDetails() {
        return conversationDetails;
    }

    @Override
    public ConversationSettings getSettings() {
        return settings;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
