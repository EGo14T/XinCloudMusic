package com.ego14t.xinmusic.entity;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/10/14 14:39
 * Description:
 */
public class UserMusicListInfo {
    private String musiclistid;
    private String musiclistName;
    private String musiclistImg;
    private Integer status;
    private Integer sumMusic;

    public String getMusiclistid() {
        return musiclistid;
    }

    public void setMusiclistid(String musiclistid) {
        this.musiclistid = musiclistid;
    }

    public String getMusiclistName() {
        return musiclistName;
    }

    public void setMusiclistName(String musiclistName) {
        this.musiclistName = musiclistName;
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

    public Integer getSumMusic() {
        return sumMusic;
    }

    public void setSumMusic(Integer sumMusic) {
        this.sumMusic = sumMusic;
    }
}
