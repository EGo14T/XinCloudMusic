package com.ego14t.feign.pojo;

public class Music {
    private Integer id;

    private Integer musicID;

    private String name;

    private String singer;

    private String album;

    private String length;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMusicID() {
        return musicID;
    }

    public void setMusicID(Integer musicID) {
        this.musicID = musicID;
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
}