package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.entity.MusicInfo;
import com.ego14t.xinmusic.newentity.MusicEntity;
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
    //根据歌曲id删除歌曲（从歌单中删除）
    String delMusicFromList(String musiclistId, String musicId);
    //把歌曲添加到歌单中
    String addMusicToList(String musicListID, String musicID);
    //检索歌曲(登录&&未登录)
    List<MusicInfoVo> getSearchUserList(String userID, String keyword);

}
