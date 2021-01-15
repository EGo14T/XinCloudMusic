package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.entity.MusicEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.entity.MusicListMusicEntity;
import com.ego14t.xinmusic.pojo.SearchUserList;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {
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

    /**
     * 检索歌曲，带用户收藏状态
     * @param defaultId 默认歌单ID
     * @param keyword 关键字
     * @return 检索结果
     */
    List<SearchUserList> searchUserList(@Param("defaultId") String defaultId, @Param("keyword") String keyword);

    /**
     *
     * @param defaultId
     * @param musiclistId
     * @return
     */
    List<SearchUserList> getUserList(@Param("defaultId") String defaultId, @Param("musiclistId") String musiclistId);

    /**
     * 获取用户默认歌单
     * @param createUserId 歌单创建者ID
     * @return 默认歌单信息
     */
    MusicListEntity getDefaultList(String createUserId);

    /**
     * 获取歌单歌曲表信息
     * @return 歌单歌曲信息
     */
    MusicListMusicEntity getMusiclistMusic(@Param("musiclistId") String musiclistId, @Param("musicId") String musicId);

    /**
     * 将歌曲添加到歌单中
     * @param addEntity 添加实体
     */
    Integer addMusicToList(MusicListMusicEntity addEntity);

    void updateId(String id, String musicId);
}
