package com.ego14t.xinmusic.pojo;

import java.util.Date;

public class MusiclistUser {
    private Integer musiclistid;

    private Integer userid;

    private String musiclistName;

    private String createTime;

    private String tags;

    private String description;

    private String musiclistImg;

    private Integer status;

    private Integer iscollecting;

    public Integer getMusiclistid() {
        return musiclistid;
    }

    public void setMusiclistid(Integer musiclistid) {
        this.musiclistid = musiclistid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMusiclistName() {
        return musiclistName;
    }

    public void setMusiclistName(String musiclistName) {
        this.musiclistName = musiclistName == null ? null : musiclistName.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMusiclistImg() {
        return musiclistImg;
    }

    public void setMusiclistImg(String musiclistImg) {
        this.musiclistImg = musiclistImg == null ? null : musiclistImg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIscollecting() {
        return iscollecting;
    }

    public void setIscollecting(Integer iscollecting) {
        this.iscollecting = iscollecting;
    }
}