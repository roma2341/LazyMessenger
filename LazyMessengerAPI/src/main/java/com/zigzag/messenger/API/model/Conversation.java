package com.zigzag.messenger.API.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 15.02.2017.
 */
public interface Conversation {
    public UUID getId();
    public List<Profile> getParticipants();
    public Date getDateCreated();
    public List<Message> getMessages();
    public ConversationDetails getDetails();
    public ConversationSettings getSettings();

}
