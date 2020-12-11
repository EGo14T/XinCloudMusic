package com.ego14t.common.common;

public enum TypePath {

    /**
     * 歌单封面
     */
    MUSICLIST_IMG("/musiclistIMG/"),

    /**
     * 歌曲文件
     */
    MUSIC_FILE("/musicFile/"),

    /**
     * 用户头像
     */
    USER_AVATAR("/useravatar/");


    private String path;

    public String getPath() {
        return path;
    }

    public void setPaht(String path) {
        this.path = path;
    }

    TypePath(String path) {
        this.path = path;
    }
}
