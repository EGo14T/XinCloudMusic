package com.ego14t.user.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class UserKey implements Serializable {
    private String id;

    private String username;

    private static final long serialVersionUID = 1L;
}