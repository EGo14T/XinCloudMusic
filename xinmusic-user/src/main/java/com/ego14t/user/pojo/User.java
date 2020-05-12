package com.ego14t.user.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User extends UserKey implements Serializable {
    private String password;

    private static final long serialVersionUID = 1L;
}