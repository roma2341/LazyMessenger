package com.softgroup.common.database.models;

import java.util.UUID;

/**
 * Created by zigza on 16.02.2017.
 */
public interface Contact {
    public UUID getId();
    public String getName();
    public String getNumber();
    public String getCity();
    public void setName(String name);
    public void setNumber(String number);
    public void setCity(String city);
}
