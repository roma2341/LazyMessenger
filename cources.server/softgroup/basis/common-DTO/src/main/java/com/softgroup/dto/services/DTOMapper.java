package com.softgroup.dto.services;
import com.softgroup.dto.entities.UserProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.plugin.util.UserProfile;

/**
 * Created by zigza on 05.04.2017.
 */
@Component
public class DTOMapper {
    @Autowired
    ModelMapper modelMapper;
    public UserProfileDTO map(UserProfile profileEntity) {
        return modelMapper.map(profileEntity, UserProfileDTO.class);
    }
}
