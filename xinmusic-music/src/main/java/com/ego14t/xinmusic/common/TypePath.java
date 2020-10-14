package com.ego14t.xinmusic.common;

public enum TypePath {

    /**
     * 歌单封面
     */
    MUSICLIST_IMG("/musiclistIMG"),

    /**
     * 歌曲文件
     */
    MUSIC_FILE("/musicFile"),

    /**
     * 用户头像
     */
    USER_AVATAR("/useravatar");


    private String paht;

    public String getPaht() {
        return paht;
    }

    public void setPaht(String paht) {
        this.paht = paht;
    }

    TypePath(String paht) {
        this.paht = paht;
    }
}
