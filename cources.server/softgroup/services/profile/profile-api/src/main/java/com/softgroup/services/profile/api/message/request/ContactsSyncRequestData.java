package com.softgroup.services.profile.api.message.request;

import com.softgroup.common.database.model.UserContact;

import java.util.List;

/**
 * Created by zigza on 28.02.2017.
 */
public class ContactsSyncRequestData {
    public List<UserContact> getAddedContacts() {
        return addedContacts;
    }

    public void setAddedContacts(List<UserContact> addedContacts) {
        this.addedContacts = addedContacts;
    }

    public List<UserContact> getRemovedContacts() {
        return removedContacts;
    }

    public void setRemovedContacts(List<UserContact> removedContacts) {
        this.removedContacts = removedContacts;
    }

    private List<UserContact> addedContacts;
   private List<UserContact> removedContacts;
}
