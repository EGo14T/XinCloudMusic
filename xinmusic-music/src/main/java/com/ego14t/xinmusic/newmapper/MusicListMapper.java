package com.ego14t.xinmusic.newmapper;

import com.ego14t.xinmusic.newentity.MusicListCollectEntity;
import com.ego14t.xinmusic.newpojo.MusicListInfo;
import com.ego14t.xinmusic.newpojo.UserMusicList;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author wangfx
 * @date 2020/11/18 14:05
 */
@Mapper
public interface MusicListMapper {
    /**
     * 获取用户收藏歌单的信息带歌曲总数
     * @param userid 用户ID
     * @return 收藏歌单信息
     */
    List<UserMusicList> getUserCollectMusicList(String userid);

    /**
     * 获取用户创建歌单的信息带歌曲总数
     * @param userid 用户ID
     * @return 创建歌单信息
     */
    List<UserMusicList> getUserCreateMusicList(String userid);

    /**
     * @return 获取推荐歌单
     */
    List<UserMusicList> getDiscoverMusicList();

    /**
     * 收藏歌单
     * @param musicListCollectEntity 实体
     * @return 主键ID
     */
    Integer addMusicToList(MusicListCollectEntity musicListCollectEntity);

    MusicListInfo getMusicListInfo(String userid, String musiclistId);
}
