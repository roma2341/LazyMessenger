package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.Message;
import com.zigzag.messenger.API.model.Profile;
import com.zigzag.messenger.API.model.Conversation;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zigza on 16.02.2017.
 */
public class UserMessage implements Message {

    @Override
    public UUID getId() {
        UUID testUUID = UUID.randomUUID();
        return null;
    }

    @Override
    public String getBody() {
        String testBody = "test body lol";
        return null;
    }

    @Override
    public Profile getAuthor() {
        return null;
    }

    @Override
    public Date getDateSended() {
        return new Date();
    }

    @Override
    public Boolean isActive() {
        return true;
    }

    @Override
    public Conversation getConversation() {
        return null;
    }
}
