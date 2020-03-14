package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.example.MusiclistMusicExample;
import com.ego14t.xinmusic.pojo.MusiclistMusicKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MusiclistMusicMapper {
    long countByExample(MusiclistMusicExample example);

    int deleteByExample(MusiclistMusicExample example);

    int deleteByPrimaryKey(MusiclistMusicKey key);

    int insert(MusiclistMusicKey record);

    int insertSelective(MusiclistMusicKey record);

    List<MusiclistMusicKey> selectByExample(MusiclistMusicExample example);

    MusiclistMusicKey selectByPrimaryKey(MusiclistMusicKey musiclistMusicKey);

    int updateByExampleSelective(@Param("record") MusiclistMusicKey record, @Param("example") MusiclistMusicExample example);

    int updateByExample(@Param("record") MusiclistMusicKey record, @Param("example") MusiclistMusicExample example);
}