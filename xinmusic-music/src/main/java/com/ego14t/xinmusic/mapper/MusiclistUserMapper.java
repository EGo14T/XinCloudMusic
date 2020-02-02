package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.MusiclistUser;
import com.ego14t.xinmusic.pojo.example.MusiclistUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusiclistUserMapper {
    int countByExample(MusiclistUserExample example);

    int deleteByExample(MusiclistUserExample example);

    int deleteByPrimaryKey(Integer musiclistid);

    int insert(MusiclistUser record);

    int insertSelective(MusiclistUser record);

    List<MusiclistUser> selectByExample(MusiclistUserExample example);

    MusiclistUser selectByPrimaryKey(Integer musiclistid);

    int updateByExampleSelective(@Param("record") MusiclistUser record, @Param("example") MusiclistUserExample example);

    int updateByExample(@Param("record") MusiclistUser record, @Param("example") MusiclistUserExample example);

    int updateByPrimaryKeySelective(MusiclistUser record);

    int updateByPrimaryKey(MusiclistUser record);
}