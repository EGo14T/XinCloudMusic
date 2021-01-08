package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.vo.MusicInfoVo;

import java.util.List;

/**
 * @author 王富昕
 * Create By EGo1ST
 * Date ：Created in 2019/9/29 11:33
 * Description：
 */
public interface MusicService {
    //根据歌曲id返回歌曲信息
    MusicInfoVo getMusicInfo(String musicId);
    //把歌曲添加到歌单中
    void addMusicToList(String musiclistId, String musicID);
    //根据歌曲id删除歌曲（从歌单中删除）
    void delMusicFromList(String musiclistId, String musicId);
    //检索歌曲(登录&&未登录)
    List<MusicInfoVo> getSearchUserList(String userId, String keyword);
    //喜欢音乐
    void likeMusic(String userId, String musicId);
    //不喜欢音乐
    void dislikeMusic(String userId, String musicId);
}
