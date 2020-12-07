package com.ego14t.comments.mapper;

import com.ego14t.comments.entity.CommentsEntity;
import java.util.List;

import com.ego14t.comments.pojo.UserComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {

    Integer createComments(CommentsEntity commentsEntity);

    UserComment getComment(String commentId);

    List<UserComment> getCommentsList(String showId);
}