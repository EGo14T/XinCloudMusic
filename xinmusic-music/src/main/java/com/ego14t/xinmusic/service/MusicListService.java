package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.entity.UserMusicListInfo;
import com.ego14t.xinmusic.pojo.MusiclistUser;

import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
public interface MusicListService {
    //获取歌单中的歌曲
    List<MusicList> getMusicList(String musicListID,String userID);
    //获取用户歌单
    List<UserMusicListInfo> getUserMusicListInfo(String userID);
    //删除歌单
    String delMusicList(String userID,String musicListID);
    //添加歌单
    String addMusicList(MusiclistUser musiclistUser);
    //修改歌单
    String updateMusicList(String musicListID, MusiclistUser musiclistUser);


}
