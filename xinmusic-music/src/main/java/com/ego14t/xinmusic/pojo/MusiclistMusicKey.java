package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
/**
 * musiclist_music
 * @author 
 */
public class MusiclistMusicKey implements Serializable {
    /**
     * 歌单的唯一标识ID
     */
    private String musiclistid;

    /**
     * 歌曲的唯一标识ID
     */
    private String musicid;

    public MusiclistMusicKey(String musiclistid, String musicid) {
        this.musiclistid = musiclistid;
        this.musicid = musicid;
    }

    public String getMusiclistid() {
        return musiclistid;
    }

    public void setMusiclistid(String musiclistid) {
        this.musiclistid = musiclistid;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    private static final long serialVersionUID = 1L;
}