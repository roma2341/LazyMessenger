package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserDevice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zigza on 30.03.2017.
 */
public interface UserDeviceRepository extends CommonOperationsRepository<UserDevice,String> {
    @Transactional
    @Modifying
    @Query("update user_device d set d.updateDateTime = ?1 where d.id = ?2")
    void setTokenUpdatingTime(Long time, String id);
}
