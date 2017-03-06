package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserContact;
import com.softgroup.common.database.model.UserProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zigza on 03.03.2017.
 */
public interface UserContactRepository extends CommonOperationsRepository<UserContact,String> {
    @Modifying
    @Query("delete from user_contact u where u in ?1")
    public List<UserContact> removeContactsInList(List<UserContact> contact);


}
