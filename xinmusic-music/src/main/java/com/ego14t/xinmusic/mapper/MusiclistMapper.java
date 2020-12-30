package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.entity.MusicListCollectEntity;
import com.ego14t.xinmusic.entity.MusicListEntity;
import com.ego14t.xinmusic.pojo.MusicListInfo;
import com.ego14t.xinmusic.pojo.UserMusiclist;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wangfx
 * @date 2020/11/18 14:05
 */
@Mapper
public interface MusiclistMapper {
    /**
     * 获取用户收藏歌单的信息带歌曲总数
     * @param userid 用户ID
     * @return 收藏歌单信息
     */
    List<UserMusiclist> getUserCollectMusicList(String userid);

    /**
     * 获取用户创建歌单的信息带歌曲总数
     *
     * @param currentUserId 当前登录用户
     * @param userid 用户ID
     * @return 创建歌单信息
     */
    List<UserMusiclist> getUserCreateMusicList(String currentUserId, String userid);

    /**
     * @return 获取推荐歌单
     */
    List<UserMusiclist> getDiscoverMusicList();

    /**
     * 收藏歌单
     * @param musicListCollectEntity 实体
     * @return 主键ID
     */
    Integer collectMusicList(MusicListCollectEntity musicListCollectEntity);

    /**
     * 查询歌单信息
     * @param userid 用户ID
     * @param musiclistId 歌单ID
     * @return 歌单信息
     */
    MusicListInfo getMusicListInfo(String userid, String musiclistId);

    Integer createMusicList(MusicListEntity createEntity);

    Integer update(MusicListEntity updateEntity);

    MusicListEntity queryObject(String userid, String musiclistId);

    Integer delCollect(String userid, String musiclistId);

    Integer delCreatedList(String userid, String musiclistId);

    void delMusicFromList(String musiclistId);
}
