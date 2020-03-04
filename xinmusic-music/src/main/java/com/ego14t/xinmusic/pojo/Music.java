package com.ego14t.xinmusic.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * music
 * @author 
 */
@Data
public class Music implements Serializable {

    private String musicID;
    /**
     * 歌曲唯一的ID
     */
    private String id;

    /**
     * 歌曲名称
     */
    private String name;

    /**
     * 歌手
     */
    private String singer;

    /**
     * 歌曲所属专辑
     */
    private String album;

    /**
     * 歌曲时长
     */
    private String length;

    /**
     * 歌曲封面
     */
    private String imgurl;

    /**
     * 歌词地址
     */
    private String lrcurl;

    private static final long serialVersionUID = 1L;
}