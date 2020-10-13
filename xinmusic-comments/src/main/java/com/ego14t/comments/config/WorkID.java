package com.ego14t.comments.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/12
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "workid")
public class WorkID {
    private int user;
    private int music;
    private int musiclist;
    private int comments;

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public int getMusiclist() {
        return musiclist;
    }

    public void setMusiclist(int musiclist) {
        this.musiclist = musiclist;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}
