package com.ego14t.comments.mapper;

import com.ego14t.comments.pojo.CommentsReply;
import com.ego14t.comments.pojo.example.CommentsReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentsReplyMapper {
    long countByExample(CommentsReplyExample example);

    int deleteByExample(CommentsReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentsReply record);

    int insertSelective(CommentsReply record);

    List<CommentsReply> selectByExample(CommentsReplyExample example);

    CommentsReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentsReply record, @Param("example") CommentsReplyExample example);

    int updateByExample(@Param("record") CommentsReply record, @Param("example") CommentsReplyExample example);

    int updateByPrimaryKeySelective(CommentsReply record);

    int updateByPrimaryKey(CommentsReply record);
}