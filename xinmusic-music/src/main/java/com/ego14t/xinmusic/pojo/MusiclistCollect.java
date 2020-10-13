package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * musiclist_collect
 * @author 
 */

public class MusiclistCollect extends MusiclistCollectKey implements Serializable {
    /**
     * 收藏时间
     */
    private LocalDateTime collectingtime;

    public LocalDateTime getCollectingtime() {
        return collectingtime;
    }

    public void setCollectingtime(LocalDateTime collectingtime) {
        this.collectingtime = collectingtime;
    }

    private static final long serialVersionUID = 1L;
}