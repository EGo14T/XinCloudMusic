package com.ego14t.xinmusic.entity;

import com.ego14t.common.entity.BaseEntity;

/**
 * @author wangfx
 * @date 2020/11/13 12:02
 */
public class MusicListMusicEntity extends BaseEntity {

    private static final long serialVersionUID = -4343886842141755820L;

    /**
     * 歌单ID
     */
    private String musiclistId;

    /**
     * 歌曲ID
     */
    private String musicId;

    public String getMusiclistId() {
        return musiclistId;
    }

    public void setMusiclistId(String musiclistId) {
        this.musiclistId = musiclistId;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
}
