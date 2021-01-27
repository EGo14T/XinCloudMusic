package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.pojo.MusicListInfo;
import com.ego14t.xinmusic.pojo.SearchUserList;
import com.ego14t.xinmusic.pojo.UserMusiclist;
import com.ego14t.xinmusic.vo.MusicInfoVo;
import com.ego14t.xinmusic.vo.MusicListVo;

import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
public interface MusicListService {
    //获取用户歌单（创建&默认）
    List<UserMusiclist> getCreateMusicListInfo(String currentUserId, String userId);
    //获取用户歌单（用户收藏）
    List<UserMusiclist> getCollectMusicListInfo(String userId);
    //获取推荐歌单
    List<UserMusiclist> getDiscoverMusicListInfo();
    //收藏歌单
    void collectMusicList(String userId, String musiclistId);
    //取消收藏歌单
    void unCollectMusicList(String userId, String musiclistId);
    //获取歌单中的歌曲（用户）
    List<MusicInfoVo> getUserMusicList(String musiclistId, String userId);
    //获取歌单信息
    MusicListInfo getMusicListInfo(String userId, String musiclistId);
    //新建歌单
    String createMusicList(MusicListVo musiclistUser);
    //删除歌单
    void delMusicList(String userId,String musiclistId, String delType);
    //修改歌单
    void updateMusicList(MusicListVo musiclistVo);
    //获取歌单信息公共方法
    List<MusicInfoVo> getMusicInfoVos(List<SearchUserList> searchUserLists);

    //void test();
}
