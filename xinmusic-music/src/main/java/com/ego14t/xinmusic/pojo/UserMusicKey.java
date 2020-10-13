package com.ego14t.xinmusic.pojo;

import java.io.Serializable;

/**
 * user_music
 * @author 
 */
public class UserMusicKey implements Serializable {
    /**
     * 用户的唯一标识ID
     */
    private String userid;

    /**
     * 歌曲的唯一标识ID
     */
    private String musicid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    private static final long serialVersionUID = 1L;
}