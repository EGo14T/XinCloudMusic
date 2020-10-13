package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * musiclist_user
 * @author 
 */

public class MusiclistUser extends MusiclistUserKey implements Serializable {
    /**
     * 歌单名称
     */
    private String musiclistName;

    /**
     * 歌单创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 歌曲Tags
     */
    private String tags;

    /**
     * 歌单描述
     */
    private String description;

    /**
     * 封面地址
     */
    private String musiclistImg;

    /**
     * 状态0：默认歌单（不能删除） 1：正常歌单 2：隐私歌单
     */
    private Integer status;

    /**
     * 歌单歌曲数
     */
    private Integer sumMusic;

    public String getMusiclistName() {
        return musiclistName;
    }

    public void setMusiclistName(String musiclistName) {
        this.musiclistName = musiclistName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
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

    public Integer getSumMusic() {
        return sumMusic;
    }

    public void setSumMusic(Integer sumMusic) {
        this.sumMusic = sumMusic;
    }

    private static final long serialVersionUID = 1L;

    public MusiclistUser(String userid, String musiclistid) {
        super(userid, musiclistid);
    }
}