package com.ego14t.xinmusic.service;

import com.ego14t.common.constant.CdnConsts;
import com.ego14t.common.constant.TypePath;
import com.ego14t.xinmusic.pojo.MusicListInfo;
import com.ego14t.xinmusic.pojo.SearchUserList;
import com.ego14t.xinmusic.pojo.UserMusiclist;
import com.ego14t.xinmusic.vo.MusicListVo;
import com.ego14t.xinmusic.vo.MusicInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
public interface MusicListService {
    //获取用户歌单（创建&默认）
    List<UserMusiclist> getCreateMusicListInfo(String currentUserId, String userID);
    //获取用户歌单（用户收藏）
    List<UserMusiclist> getCollectMusicListInfo(String userID);
    //获取推荐歌单
    List<UserMusiclist> getDiscoverMusicListInfo();
    //收藏歌单
    void collectMusicList(String userId, String musicListID);
    //获取歌单中的歌曲（用户）
    List<MusicInfoVo> getUserMusicList(String musicListID, String userID);
    //获取歌单信息
    MusicListInfo getMusicListInfo(String userID, String musicListID);
    //新建歌单
    String createMusicList(MusicListVo musiclistUser);
    //删除歌单
    void delMusicList(String userID,String musiclistId, String delType);
    //修改歌单
    void updateMusicList(MusicListVo musicListVo);
    //获取歌单信息公共方法
    List<MusicInfoVo> getMusicInfoVos(List<SearchUserList> searchUserLists);
}
