package com.ego14t.comments.service.Impl;


import com.ego14t.comments.common.DataConsts;
import com.ego14t.comments.entity.CommentsEntity;
import com.ego14t.comments.pojo.UserComment;
import com.ego14t.comments.vo.CommentsResponseVo;
import com.ego14t.comments.mapper.CommentsMapper;
import com.ego14t.comments.service.CommentsService;
import com.ego14t.comments.vo.CreateCommentsVo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/30 17:16
 * Description:
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Resource
    private CommentsMapper commentsMapper;

    @Override
    @Transactional
    public String saveComments(CreateCommentsVo createCommentsVo, String fromUserId) {
        CommentsEntity createEntity = new CommentsEntity();
        createEntity.setFromUserId(fromUserId);
        createEntity.setToUserId(createCommentsVo.getToUserId());
        createEntity.setShowId(createCommentsVo.getShowId());
        createEntity.setStatus(DataConsts.NORMAL_STATUS);
        createEntity.setContent(createCommentsVo.getContent());
        createEntity.setToId(Optional.ofNullable(createCommentsVo.getToId()).orElse(null));
        Integer res = commentsMapper.createComments(createEntity);
        if (res ==1) {
            return createEntity.getId();
        }
        return null;
    }

    @Override
    public CommentsResponseVo getComment(String commentId, String userid) {
        CommentsResponseVo result = new CommentsResponseVo();
        UserComment originComment = commentsMapper.getComment(commentId);
        result.setOriginComments(originComment);
        if (originComment != null && originComment.getToId() != null){
            UserComment replyComment = commentsMapper.getComment(originComment.getToId());
            result.setReplyComments(replyComment);
        }
        return result;
    }

    @Override
    public List<CommentsResponseVo> getAllComments(String showId, Integer page, Integer total) {
        List<UserComment> userCommentList = commentsMapper.getCommentsList(showId);
        if (userCommentList == null) {
            return null;
        }
        //转换成<id,UserComment>
        Map<String, UserComment> collect = userCommentList.stream().collect(Collectors.toMap(UserComment::getId, userComment -> userComment));

        return userCommentList.stream().map(comment -> {
            CommentsResponseVo resultVo = new CommentsResponseVo();
            if (comment.getToId() != null) {
                resultVo.setReplyComments(collect.get(comment.getToId()));
            }
            resultVo.setOriginComments(comment);
            return resultVo;
        }).collect(Collectors.toList());
    }
}
