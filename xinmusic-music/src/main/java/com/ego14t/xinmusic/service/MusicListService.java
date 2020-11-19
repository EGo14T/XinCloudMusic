package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.newpojo.MusicListInfo;
import com.ego14t.xinmusic.newpojo.UserMusicList;
import com.ego14t.xinmusic.pojo.MusiclistUser;
import com.ego14t.xinmusic.vo.CreateMusicListVo;
import com.ego14t.xinmusic.vo.MusicInfoVo;

import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
public interface MusicListService {
    //获取用户歌单（创建&默认）
    List<UserMusicList> getCreateMusicListInfo(String userID);
    //获取用户歌单（用户收藏）
    List<UserMusicList> getCollectMusicListInfo(String userID);
    //获取推荐歌单
    List<UserMusicList> getDiscoverMusicListInfo();
    //收藏歌单
    Integer collectMusicList(String userId, String musicListID);
    //获取歌单中的歌曲（用户）
    List<MusicInfoVo> getUserMusicList(String musicListID, String userID);
    //获取歌单信息
    MusicListInfo getMusicListInfo(String userID, String musicListID);
    //新建歌单
    String createMusicList(CreateMusicListVo musiclistUser);
    //删除歌单
    String delMusicList(String userID,String musicListID);
    //修改歌单
    String updateMusicList(String musicListID, MusiclistUser musiclistUser);

}
