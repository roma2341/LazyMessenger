package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity(name="user_conversation")
public class UserConversation {
    public enum ConversationType {INDIVIDUAL_CHAT,GROUP_CHAT,ALL_CHAT};
    public UserConversation(){

    }
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @ManyToMany()
    private List<UserProfile> participants;

    @OneToMany(mappedBy = "author")
    private List<UserMessage> messages;

    @OneToOne()
    private UserConversationDetails conversationDetails;

    @OneToOne()
    private UserConversationSettings settings;

    private Long dateCreated;

    private String title;

    ConversationType type;

    public String getId() {
        return id;
    }

    public List<UserProfile> getParticipants() {
        return participants;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public List<UserMessage> getMessages() {
        return messages;
    }

    public UserConversationDetails getDetails() {
        return conversationDetails;
    }

    public UserConversationSettings getSettings() {
        return settings;
    }

    public String getTitle() {
        return title;
    }

    public ConversationType getType() {
        return type;
    }
}
