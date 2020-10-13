package com.ego14t.user.pojo;

import java.io.Serializable;

/**
 * musiclist_user
 * @author 
 */
public class MusiclistUserKey implements Serializable {
    /**
     * 歌单的唯一表示ID
     */
    private String musiclistid;

    /**
     * 用户的唯一标识ID
     */
    private String userid;

    public String getMusiclistid() {
        return musiclistid;
    }

    public void setMusiclistid(String musiclistid) {
        this.musiclistid = musiclistid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;
}