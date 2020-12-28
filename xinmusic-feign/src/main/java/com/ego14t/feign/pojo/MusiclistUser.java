package com.ego14t.feign.pojo;

public class MusiclistUser {
    private Integer musiclistid;

    private Integer userid;

    private String musiclistName;

    private String createTime;

    private String tags;

    private String description;

    private String musiclistImg;

    private Integer status;

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
        this.musiclistName = musiclistName;
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
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusiclistImg() {
        return musiclistImg;
    }

    public void setMusiclistImg(String musiclistImg) {
        this.musiclistImg = musiclistImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}