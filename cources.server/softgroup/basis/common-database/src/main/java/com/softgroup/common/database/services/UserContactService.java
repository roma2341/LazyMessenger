package com.softgroup.common.database.services;

import com.softgroup.common.database.model.UserContact;
import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.repository.UserContactRepository;
import com.softgroup.common.database.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zigza on 03.03.2017.
 */
@Service
public class UserContactService {
    @Autowired
    UserContactRepository contactRepository;
    @Autowired
    UserProfileRepository profileRepository;


    private void saveContacts(List<UserContact> contacts){
        contactRepository.save(contacts);
    }
    private void removeContacts(List<UserContact> contacts){
        contactRepository.delete(contacts);
    }
    @Transactional
    public void syncContacts(ContactsCommit commit){
        removeContacts(commit.removedContacts);
        saveContacts(commit.addedContacts);
    }
    public static  class ContactsCommit{
        public void setAddedContacts(List<UserContact> addedContacts) {
            this.addedContacts = addedContacts;
        }

        public void setRemovedContacts(List<UserContact> removedContacts) {
            this.removedContacts = removedContacts;
        }
        private List<UserContact> addedContacts;
        private List<UserContact> removedContacts;
    }


}
