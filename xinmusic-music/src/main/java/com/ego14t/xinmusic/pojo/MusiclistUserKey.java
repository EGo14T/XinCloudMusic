package com.ego14t.xinmusic.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * musiclist_user
 * @author 
 */
@Data
@AllArgsConstructor
public class MusiclistUserKey implements Serializable {
    /**
     * 用户的唯一标识ID
     */
    private String userid;

    /**
     * 歌单的唯一表示ID
     */
    private String musiclistid;

    private static final long serialVersionUID = 1L;
}