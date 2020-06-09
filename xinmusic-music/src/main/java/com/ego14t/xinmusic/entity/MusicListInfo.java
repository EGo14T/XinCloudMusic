package com.ego14t.xinmusic.entity;

import com.ego14t.xinmusic.pojo.MusiclistUser;
import lombok.Getter;
import lombok.Setter;

public class MusicListInfo extends MusiclistUser {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String avatar;

    @Getter
    @Setter
    private Integer isCollected;

    public MusicListInfo(String userid, String musiclistid) {
        super(userid, musiclistid);
    }
}
