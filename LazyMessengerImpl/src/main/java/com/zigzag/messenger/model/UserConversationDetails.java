package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.ConversationDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserConversationDetails implements ConversationDetails {

    @Id
    @GeneratedValue
    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }
}
