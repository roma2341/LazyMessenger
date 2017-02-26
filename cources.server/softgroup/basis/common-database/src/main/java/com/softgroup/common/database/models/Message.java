package com.softgroup.common.database.models;


import java.util.Date;

/**
 * Created by zigza on 15.02.2017.
 */
public interface Message {
    public String getId();
    public String getBody();
    public Profile getAuthor();
    public Date getDateSended();
    public Boolean isActive();
    public Conversation getConversation();
}
