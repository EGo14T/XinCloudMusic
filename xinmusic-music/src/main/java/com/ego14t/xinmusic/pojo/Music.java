package com.ego14t.xinmusic.pojo;

import java.io.Serializable;

/**
 * music
 * @author 
 */
public class Music implements Serializable {

    private String musicID;
    /**
     * 歌曲唯一的ID
     */
    private String id;

    /**
     * 歌曲名称
     */
    private String name;

    /**
     * 歌手
     */
    private String singer;

    /**
     * 歌曲所属专辑
     */
    private String album;

    /**
     * 歌曲时长
     */
    private String length;

    public String getMusicID() {
        return musicID;
    }

    public void setMusicID(String musicID) {
        this.musicID = musicID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    private static final long serialVersionUID = 1L;
}