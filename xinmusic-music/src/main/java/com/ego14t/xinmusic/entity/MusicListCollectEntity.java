package com.ego14t.xinmusic.entity;

import com.ego14t.common.entity.BaseEntity;

/**
 * @author wangfx
 * @date 2020/11/13 12:01
 */
public class MusicListCollectEntity extends BaseEntity {

    private static final long serialVersionUID = -8514109779916451801L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 歌单ID
     */
    private String musiclistId;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMusiclistId() {
        return musiclistId;
    }

    public void setMusiclistId(String musiclistId) {
        this.musiclistId = musiclistId;
    }
}
