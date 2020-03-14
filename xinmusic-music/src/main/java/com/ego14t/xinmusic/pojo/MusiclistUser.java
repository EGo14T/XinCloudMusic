package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import lombok.*;

/**
 * musiclist_user
 * @author 
 */

public class MusiclistUser extends MusiclistUserKey implements Serializable {
    /**
     * 歌单名称
     */
    @Getter
    @Setter
    private String musiclistName;

    /**
     * 歌单创建时间
     */
    @Getter
    @Setter
    private LocalDate createTime;

    /**
     * 歌曲Tags
     */
    @Getter
    @Setter
    private String tags;

    /**
     * 歌单描述
     */
    @Getter
    @Setter
    private String description;

    /**
     * 封面地址
     */
    @Getter
    @Setter
    private String musiclistImg;

    /**
     * 状态0：默认歌单（不能删除） 1：正常歌单 2：隐私歌单
     */
    @Getter
    @Setter
    private Integer status;

    /**
     * 是否被收藏 0未收藏  1已收藏
     */
    @Getter
    @Setter
    private Integer iscollecting;

    private static final long serialVersionUID = 1L;

    public MusiclistUser(String userid, String musiclistid) {
        super(userid, musiclistid);
    }
}