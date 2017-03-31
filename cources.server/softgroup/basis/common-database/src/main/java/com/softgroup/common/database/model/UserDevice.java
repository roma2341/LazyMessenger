package com.softgroup.common.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zigza on 31.03.2017.
 */
@Entity(name="user_device")
public class UserDevice {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "locale_code")
    private String localeCode;

    @Column(name = "update_date_time")
    private Date updateDateTime;

    @ManyToOne
    private UserProfile owner;

    private String name;
}
