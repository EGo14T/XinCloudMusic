package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.entity.MusicList;
import org.springframework.http.ResponseEntity;

/**
 * @author 王富昕
 * Create By EGo1ST
 * Date ：Created in 2019/9/29 11:33
 * Description：
 */
public interface MusicService {
    //根据歌曲id返回歌曲信息
    MusicList getMusic(int id);
    //根据歌曲id删除歌曲（从歌单中删除）
    String delMusic(Integer musicID, Integer musicListID);
    //把歌曲添加到歌单中
    String addMusicToList(Integer musicID, Integer musicListID);

}
