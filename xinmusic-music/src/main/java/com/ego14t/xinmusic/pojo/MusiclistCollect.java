package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * musiclist_collect
 * @author 
 */

public class MusiclistCollect extends MusiclistCollectKey implements Serializable {
    /**
     * 收藏时间
     */
    @Getter
    @Setter
    private LocalDateTime collectingtime;

    private static final long serialVersionUID = 1L;
}