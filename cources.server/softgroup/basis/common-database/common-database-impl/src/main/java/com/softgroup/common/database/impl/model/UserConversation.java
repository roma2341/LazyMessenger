package com.softgroup.common.database.impl.model;

import com.softgroup.common.database.api.model.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserConversation implements Conversation {
    public UserConversation(){

    }
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

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

    public String getId() {
        return id;
    }

    public List<Profile> getParticipants() {
        return participants;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public ConversationDetails getDetails() {
        return conversationDetails;
    }

    public ConversationSettings getSettings() {
        return settings;
    }

    public String getTitle() {
        return title;
    }

    public ConversationType getType() {
        return null;
    }
}
