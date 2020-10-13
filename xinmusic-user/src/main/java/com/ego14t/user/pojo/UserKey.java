package com.ego14t.user.pojo;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class UserKey implements Serializable {

    private String id;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private static final long serialVersionUID = 1L;
}