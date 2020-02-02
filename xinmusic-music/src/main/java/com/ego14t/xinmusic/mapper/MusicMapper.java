package com.ego14t.xinmusic.mapper;

import com.ego14t.xinmusic.pojo.Music;
import com.ego14t.xinmusic.pojo.example.MusicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicMapper {
    int countByExample(MusicExample example);

    int deleteByExample(MusicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Music record);

    int insertSelective(Music record);

    List<Music> selectByExample(MusicExample example);

    Music selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByExample(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);

    List<Music> searchMusicList(Integer id);

    List<Music> searchCollection(Integer userId);

    List<Music> searchNumList(Integer musicListID,Integer userId);

    void delMusicListById(Integer id);
}