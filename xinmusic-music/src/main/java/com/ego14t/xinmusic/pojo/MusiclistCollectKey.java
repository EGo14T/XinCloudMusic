package com.ego14t.xinmusic.pojo;

import java.io.Serializable;

/**
 * musiclist_collect
 * @author 
 */
public class MusiclistCollectKey implements Serializable {
    /**
     * 歌单ID
     */
    private String musiclistid;

    /**
     * 用户ID
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

    private static final long serialVersionUID = 1L;
}