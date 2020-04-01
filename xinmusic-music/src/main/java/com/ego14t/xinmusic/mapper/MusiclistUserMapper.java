package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.entity.MusicListInfo;
import com.ego14t.xinmusic.entity.UserMusicListInfo;
import com.ego14t.xinmusic.pojo.MusiclistUser;
import com.ego14t.xinmusic.pojo.example.MusiclistUserExample;
import com.ego14t.xinmusic.pojo.MusiclistUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MusiclistUserMapper {
    long countByExample(MusiclistUserExample example);

    int deleteByExample(MusiclistUserExample example);

    int deleteByPrimaryKey(MusiclistUserKey key);

    int insert(MusiclistUser record);

    int insertSelective(MusiclistUser record);

    List<MusiclistUser> selectByExample(MusiclistUserExample example);

    MusiclistUser selectByPrimaryKey(MusiclistUserKey key);

    int updateByExampleSelective(@Param("record") MusiclistUser record, @Param("example") MusiclistUserExample example);

    int updateByExample(@Param("record") MusiclistUser record, @Param("example") MusiclistUserExample example);

    int updateByPrimaryKeySelective(MusiclistUser record);

    int updateByPrimaryKey(MusiclistUser record);

    MusicListInfo searchMusicListInfo(String musiclistid);

    List<UserMusicListInfo> getCreateMusicListInfo(String userId);


}