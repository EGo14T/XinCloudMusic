package com.ego14t.xinmusic.newpojo;

import com.ego14t.xinmusic.newentity.MusicEntity;

/**
 * @author wangfx
 * @date 2020/11/17 13:34
 */
public class SearchUserList extends MusicEntity {

    private static final long serialVersionUID = -4346771968758154025L;

    private String collect;

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }
}
