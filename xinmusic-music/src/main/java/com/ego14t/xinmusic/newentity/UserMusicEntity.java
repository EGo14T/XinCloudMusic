package com.ego14t.xinmusic.newentity;

/**
 * @author wangfx
 * @date 2020/11/13 12:02
 */
public class UserMusicEntity extends BaseEntity{

    private static final long serialVersionUID = -6429053079277973820L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 歌曲ID
     */
    private String musicId;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
}
