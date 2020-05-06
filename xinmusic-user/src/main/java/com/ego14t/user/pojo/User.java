package com.ego14t.user.pojo;

import java.io.Serializable;
import lombok.Data;

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