package com.ego14t.xinmusic.pojo;

import java.io.Serializable;

/**
 * musiclist_user
 * @author 
 */
public class MusiclistUserKey implements Serializable {
    /**
     * 用户的唯一标识ID
     */
    private String userid;

    /**
     * 歌单的唯一表示ID
     */
    private String musiclistid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMusiclistid() {
        return musiclistid;
    }

    public void setMusiclistid(String musiclistid) {
        this.musiclistid = musiclistid;
    }

    private static final long serialVersionUID = 1L;

    public MusiclistUserKey(String userid, String musiclistid) {
    }
}