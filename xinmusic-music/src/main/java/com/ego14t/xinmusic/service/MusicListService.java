package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.entity.MusicInfo;
import com.ego14t.xinmusic.entity.MusicListInfo;
import com.ego14t.xinmusic.entity.UserMusicListInfo;
import com.ego14t.xinmusic.pojo.MusiclistUser;

import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
public interface MusicListService {
    //获取歌单中的歌曲（用户）
    List<MusicInfo> getUserMusicList(String musicListID, String userID);
    //获取用户歌单（创建&默认）
    List<UserMusicListInfo> getCreateMusicListInfo(String userID);
    //获取用户歌单（用户收藏）
    List<UserMusicListInfo> getCollectMusicListInfo(String userID);
    //获取推荐歌单
    List<UserMusicListInfo> getDiscoverMusicListInfo();
    //收藏歌单
    Integer collectMusicList(String userId, String musicListID);
    //获取歌单信息
    MusicListInfo getMusicListInfo(String userID,String musicListID);
    //删除歌单
    String delMusicList(String userID,String musicListID);
    //添加歌单
    String addMusicList(MusiclistUser musiclistUser);
    //修改歌单
    String updateMusicList(String musicListID, MusiclistUser musiclistUser);

}
