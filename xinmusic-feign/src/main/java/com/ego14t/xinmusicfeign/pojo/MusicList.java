package com.ego14t.xinmusicfeign.pojo;

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

    private int id;
    private String name;
    private String artist;
    private String album;
    private String length;
    private String url;
    private String lrc;
    private String img;
    private int collection;

    //创建无参构造器 @Tolerate 绕过编译器检查，解决与@Data @Builder 一起使用出现的冲突
    //无参构造器 解决redis的冲突
    @Tolerate
    public MusicList() {
    }
}
