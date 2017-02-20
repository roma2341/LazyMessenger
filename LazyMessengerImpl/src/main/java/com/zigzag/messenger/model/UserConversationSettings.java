package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.Conversation;
import com.zigzag.messenger.API.model.ConversationSettings;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
public class UserConversationSettings implements ConversationSettings {
    @Id
    @GeneratedValue
    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }
}
