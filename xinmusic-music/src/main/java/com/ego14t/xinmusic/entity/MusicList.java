package com.ego14t.xinmusic.entity;

import java.io.Serializable;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 14:36
 * Description：音乐列表的实体类
 */

public class MusicList implements Serializable {
    private static final long serialVersionUID = 716387502575184309L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    private String id;
    private String name;
    private String singer;
    private String album;
    private String length;
    private String url;
    private int collection;

}
