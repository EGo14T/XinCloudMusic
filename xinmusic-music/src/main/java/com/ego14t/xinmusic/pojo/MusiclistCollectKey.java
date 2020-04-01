package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * musiclist_collect
 * @author 
 */
@Data
public class MusiclistCollectKey implements Serializable {
    /**
     * 歌单ID
     */
    private String musiclistid;

    /**
     * 用户ID
     */
    private String userid;

    private static final long serialVersionUID = 1L;
}