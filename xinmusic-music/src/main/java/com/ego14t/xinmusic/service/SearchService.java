package com.ego14t.xinmusic.service;

import com.ego14t.xinmusic.entity.MusicList;

import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/19
 * Description:
 */
public interface SearchService {

    //检索歌曲
    List<MusicList> getSearchList(String keyword);

    List<MusicList> getSearchUserList(String userID, String keyword);
}
