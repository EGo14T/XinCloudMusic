package com.ego14t.user.pojo;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User extends UserKey implements Serializable {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static final long serialVersionUID = 1L;
}