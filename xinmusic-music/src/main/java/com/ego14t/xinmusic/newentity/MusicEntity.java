package com.ego14t.xinmusic.newentity;

/**
 * @author wangfx
 * @date 2020/11/13 12:01
 */
public class MusicEntity extends BaseEntity{

    private static final long serialVersionUID = -5657647265137113745L;

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
}
