package com.ego14t.feign.vo;

import java.io.Serializable;

/**
 * @author wangfx
 * @date 2020/11/13 14:35
 */
public class MusicInfoVo implements Serializable {

    private static final long serialVersionUID = -9020586775070001190L;

    /**
     * 歌曲ID
     */
    private String musicId;

    /**
     * 歌曲名称
     */
    private String musicName;

    /**
     * 歌手名
     */
    private String singer;

    /**
     * 专辑名
     */
    private String album;

    /**
     * 歌曲长度
     */
    private String length;

    /**
     * 歌曲URL
     */
    private String url;

    /**
     * 是否收藏
     */
    private Integer collection;

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }
}
