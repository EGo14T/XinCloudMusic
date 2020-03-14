package com.ego14t.xinmusic.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * musiclist_music
 * @author 
 */
@Data
@AllArgsConstructor
public class MusiclistMusicKey implements Serializable {
    /**
     * 歌单的唯一标识ID
     */
    private String musiclistid;

    /**
     * 歌曲的唯一标识ID
     */
    private String musicid;

    private static final long serialVersionUID = 1L;
}