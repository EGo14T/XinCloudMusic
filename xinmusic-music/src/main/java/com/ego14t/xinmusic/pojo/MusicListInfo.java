package com.ego14t.xinmusic.pojo;

import com.ego14t.xinmusic.entity.MusicListEntity;

/**
 * @author wangfx
 * @date 2020/11/18 17:34
 */
public class MusicListInfo extends MusicListEntity {

    private static final long serialVersionUID = -4514864304689896378L;

    private String nickname;

    private String avatar;

    private String collect;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }
}
