package com.softgroup.common.database.services;

import com.softgroup.common.database.model.UserDevice;
import com.softgroup.common.database.repository.UserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 20:52
 */
@Component
public class UserDeviceService {
    @Autowired
private UserDeviceRepository deviceRepository;
    public UserDevice insertUserDevice(UserDevice deviceEntity) {
        return deviceRepository.save(deviceEntity);
    }
    public UserDevice findUserDeviceById(String id) {
        return deviceRepository.findById(id);
    }
    public void setTokenUpdatingTime (Long time, String id) {
        deviceRepository.setTokenUpdatingTime(time,id);
    }
}
