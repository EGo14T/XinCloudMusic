package com.ego14t.xinmusic.entity;

import com.ego14t.xinmusic.pojo.MusiclistUser;

public class MusicListInfo extends MusiclistUser {

    private String username;

    private String avatar;

    private Integer isCollected;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Integer isCollected) {
        this.isCollected = isCollected;
    }

    public MusicListInfo(String userid, String musiclistid) {
        super(userid, musiclistid);
    }
}
