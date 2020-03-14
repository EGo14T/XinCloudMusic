package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * user_music
 * @author 
 */
@Data
public class UserMusicKey implements Serializable {
    /**
     * 用户的唯一标识ID
     */
    private String userid;

    /**
     * 歌曲的唯一标识ID
     */
    private String musicid;

    private static final long serialVersionUID = 1L;
}