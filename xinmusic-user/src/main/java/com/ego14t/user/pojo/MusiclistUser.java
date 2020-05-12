package com.ego14t.user.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

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

    private static final long serialVersionUID = 1L;
}