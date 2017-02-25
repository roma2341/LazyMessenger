package com.zigzag.messenger.security;

import com.zigzag.messenger.API.security.Token;

/**
 * Created by zigza on 17.02.2017.
 */
public class AuthToken implements Token {
    public AuthToken(String userName,String password){
    this.userName = userName;
    this.password = password;
    }
    @Override
    public String getUsername() {
        return null;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return null;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    String userName;
    String password;


}
