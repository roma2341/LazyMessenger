package com.zigzag.messanger.Model;

import com.zigzag.messenger.API.Model.Conversation;
import com.zigzag.messenger.API.Model.Message;
import com.zigzag.messenger.API.Model.Profile;

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
