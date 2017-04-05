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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<UserMessage> messages) {
        this.messages = messages;
    }

    public UserConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(UserConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }

    public UserConversationSettings getSettings() {
        return settings;
    }

    public void setSettings(UserConversationSettings settings) {
        this.settings = settings;
    }

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    public Long getLastMessageIndex() {
        return lastMessageIndex;
    }

    public void setLastMessageIndex(Long lastMessageIndex) {
        this.lastMessageIndex = lastMessageIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @OneToMany(mappedBy = "sender")
    private List<UserMessage> messages;

    @OneToOne()
    private UserConversationDetails conversationDetails;

    @OneToOne()
    private UserConversationSettings settings;


   private ConversationType type;
   private String logoImageUri;
   private Long lastMessageIndex;
   private String name;


}
