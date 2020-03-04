package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * musiclist_user
 * @author 
 */
@Data
public class MusiclistUser extends MusiclistUserKey implements Serializable {
    /**
     * 歌单名称
     */
    private String musiclistName;

    /**
     * 歌单创建时间
     */
    private Date createTime;

    /**
     * 歌曲Tags
     */
    private String tags;

    /**
     * 歌单描述
     */
    private String description;

    /**
     * 封面地址
     */
    private String musiclistImg;

    /**
     * 状态0：默认歌单（不能删除） 1：正常歌单 2：隐私歌单
     */
    private Integer status;

    /**
     * 是否被收藏 0未收藏  1已收藏
     */
    private Integer iscollecting;

    private static final long serialVersionUID = 1L;
}