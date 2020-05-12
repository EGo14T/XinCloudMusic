package com.ego14t.user.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * musiclist_user
 * @author 
 */
@Data
public class MusiclistUserKey implements Serializable {
    /**
     * 歌单的唯一表示ID
     */
    private String musiclistid;

    /**
     * 用户的唯一标识ID
     */
    private String userid;

    private static final long serialVersionUID = 1L;
}