package com.ego14t.comments.service.Impl;

import com.ego14t.comments.entity.ReplyEntity;
import com.ego14t.comments.mapper.CommentsInfoMapper;
import com.ego14t.comments.mapper.CommentsReplyMapper;
import com.ego14t.comments.pojo.CommentsInfo;
import com.ego14t.comments.pojo.CommentsReply;
import com.ego14t.comments.pojo.example.CommentsInfoExample;
import com.ego14t.comments.pojo.example.CommentsReplyExample;
import com.ego14t.comments.service.CommentsService;
import com.ego14t.comments.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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
    private CommentsInfoMapper commentsInfoMapper;

    @Resource
    private CommentsReplyMapper commentsReplyMapper;


    @Override
    public String saveComments(CommentsInfo commentsInfo) {
        commentsInfoMapper.insertSelective(commentsInfo);
        return commentsInfo.getId();
    }

    @Override
    public List<CommentsInfo> findByOwnerId(String ownerId) {
        CommentsInfoExample commentsInfoExample = new CommentsInfoExample();
        commentsInfoExample.createCriteria().andOwnerIdEqualTo(ownerId);
        return commentsInfoMapper.selectByExample(commentsInfoExample);
    }

    @Override
    public String saveReplay(CommentsReply commentsReply) {
        commentsReplyMapper.insertSelective(commentsReply);
        return commentsReply.getCommentId();
    }

    @Override
    public List<ReplyEntity> getReply(String commentId) {
        CommentsReplyExample commentsReplyExample = new CommentsReplyExample();
        commentsReplyExample.createCriteria().andCommentIdEqualTo(commentId);
        List<CommentsReply> commentsReplies = commentsReplyMapper.selectByExample(commentsReplyExample);
        List<ReplyEntity> replyEntities = commentsReplies
                .stream().map(entity -> {
                    ReplyEntity replyEntity = new ReplyEntity();
                    BeanCopyUtils.copy(entity,replyEntity);
                    replyEntity.setDate(entity.getCreateTime());
                    return replyEntity;
                }).collect(Collectors.toList());
        return replyEntities;
    }
}
