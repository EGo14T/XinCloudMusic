package com.ego14t.xinmusic.pojo;

import com.ego14t.xinmusic.entity.MusicListEntity;

/**
 * @author wangfx
 * @date 2020/11/18 14:10
 * 用户创建&&收藏的歌单
 */
public class UserMusicList extends MusicListEntity {

    private static final long serialVersionUID = 2657783957671867309L;

    private Integer musicSum;

    public Integer getMusicSum() {
        return musicSum;
    }

    public void setMusicSum(Integer musicSum) {
        this.musicSum = musicSum;
    }
}
