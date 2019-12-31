package com.ego14t.comments.mapper;

import com.ego14t.comments.pojo.CommentsInfo;

import java.util.List;

import com.ego14t.comments.pojo.example.CommentsInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentsInfoMapper {
    long countByExample(CommentsInfoExample example);

    int deleteByExample(CommentsInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommentsInfo record);

    int insertSelective(CommentsInfo record);

    List<CommentsInfo> selectByExample(CommentsInfoExample example);

    CommentsInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommentsInfo record, @Param("example") CommentsInfoExample example);

    int updateByExample(@Param("record") CommentsInfo record, @Param("example") CommentsInfoExample example);

    int updateByPrimaryKeySelective(CommentsInfo record);

    int updateByPrimaryKey(CommentsInfo record);
}