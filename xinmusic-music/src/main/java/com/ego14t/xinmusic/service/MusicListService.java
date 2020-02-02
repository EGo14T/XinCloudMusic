package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.entity.MusicList;
import com.ego14t.xinmusic.entity.MusicListInfo;
import com.ego14t.xinmusic.entity.ResponseJsonResult;
import com.ego14t.xinmusic.pojo.MusiclistUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Create By EGo1ST
 * Date ：Created in 2019/8/2 11:17
 * Description：
 */
public interface MusicListService {
    //获取歌单中的歌曲
    List<MusicList> getMusicList(Integer musicListID,Integer userId);
    //获取用户歌单
    List<MusicListInfo> getMusicListInfo(Integer userId);
    //删除歌单
    String delMusicList(Integer id);
    //添加歌单
    int addMusicList(MusiclistUser musiclistUser);
    //修改歌单
    int updateMusicList(Integer id, MusiclistUser musiclistUser);


}
