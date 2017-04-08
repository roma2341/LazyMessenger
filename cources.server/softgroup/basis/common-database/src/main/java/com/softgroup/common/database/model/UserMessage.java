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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public UserProfile getSender() {
        return sender;
    }

    public void setSender(UserProfile sender) {
        this.sender = sender;
    }

    public UserConversation getConversation() {
        return conversation;
    }

    public void setConversation(UserConversation conversation) {
        this.conversation = conversation;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Long getDateSended() {
        return dateSended;
    }

    public void setDateSended(Long dateSended) {
        this.dateSended = dateSended;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getServerReceiveTime() {
        return serverReceiveTime;
    }

    public void setServerReceiveTime(Long serverReceiveTime) {
        this.serverReceiveTime = serverReceiveTime;
    }

    public Long getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(Long messageIndex) {
        this.messageIndex = messageIndex;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    String payload;

    @ManyToOne(targetEntity = UserProfile.class)
    UserProfile sender;

    @ManyToOne(targetEntity = UserConversation.class)
    UserConversation conversation;

    MessageType messageType;

   private Long dateSended;
   private Boolean isActive;

   MessageStatus status;
   Long createTime;
   Long serverReceiveTime;
   Long messageIndex;

    public UserMessage(String payload, UserProfile sender){
        this.payload = payload;
        this.sender = sender;
    }
}
