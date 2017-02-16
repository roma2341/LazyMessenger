package com.zigzag.messenger.API.Model;


import java.util.Date;
import java.util.UUID;

/**
 * Created by zigza on 15.02.2017.
 */
public interface Message {
    public UUID getId();
    public String getBody();
    public Profile getAuthor();
    public Date getDateSended();
    public Boolean isActive();
    public Conversation getConversation();
}
