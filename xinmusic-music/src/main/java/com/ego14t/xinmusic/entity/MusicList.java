package com.ego14t.xinmusic.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 14:36
 * Description：音乐列表的实体类
 */

@Data
@Builder
public class MusicList implements Serializable {
    private static final long serialVersionUID = 716387502575184309L;

    private String id;
    private String name;
    private String singer;
    private String album;
    private String length;
    private String url;
    private int collection;

    @Tolerate
    public MusicList() {
    }
}
