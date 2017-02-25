package com.zigzag.messenger.model;

import com.zigzag.messenger.API.model.Conversation;
import com.zigzag.messenger.API.model.ConversationSettings;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by zigza on 20.02.2017.
 */
@Entity
public class UserConversationSettings implements ConversationSettings {
    public UserConversationSettings(){

    }
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Override
    public String getId() {
        return id;
    }
}
