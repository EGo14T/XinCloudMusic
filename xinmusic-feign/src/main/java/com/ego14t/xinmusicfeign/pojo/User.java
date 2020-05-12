package com.ego14t.xinmusicfeign.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private String id;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}