package com.ego14t.xinmusic.newmapper;

import com.ego14t.xinmusic.newentity.MusicEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MusicMapper1 {
    /**
     * 查询歌曲基本信息
     * @param musicId 歌曲ID
     * @return 歌曲基本信息
     */
    MusicEntity getMusicInfo(String musicId);

    /**
     * 将歌曲从歌单中删除
     * @param musiclistId 歌单ID
     * @param musicId 歌曲ID
     * @return 删除条数
     */
    int delMusicFromList(String musiclistId, String musicId);


}
