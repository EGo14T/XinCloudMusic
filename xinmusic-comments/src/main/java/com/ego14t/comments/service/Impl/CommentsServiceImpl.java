package com.ego14t.comments.service.Impl;


import com.ego14t.comments.entity.CommentsEntity;
import com.ego14t.comments.entity.CommentsResponseResult;
import com.ego14t.comments.mapper.CommentsMapper;
import com.ego14t.comments.mapper.UserInfoMapper;
import com.ego14t.comments.pojo.Comments;
import com.ego14t.comments.pojo.UserInfo;
import com.ego14t.comments.service.CommentsService;
import com.ego14t.comments.utils.BeanCopyUtils;
import com.ego14t.comments.utils.UidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;


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

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public CommentsResponseResult saveComments(Comments comments) {

        //设置基础值 全局唯一ID  创建时间  状态
        comments.setId(UidUtils.genUniqueKey());
        comments.setCreateTime(LocalDateTime.now());
        comments.setState(1);
        commentsMapper.insertSelective(comments);

        //查询用户昵称和头像信息
        UserInfo fromInfo = userInfoMapper.selectByPrimaryKey(comments.getFromId());
        String fromName = fromInfo.getName();
        String fromAvatar = fromInfo.getAvatar();

        CommentsEntity replyComments = new CommentsEntity();
        BeanCopyUtils.copy(comments,replyComments);
        replyComments.setUserName(fromName);
        replyComments.setUserAvatar(fromAvatar);

        //判断是否是回复别人的评论
        if (comments.getToId().isEmpty()){
            return CommentsResponseResult.builder()
                    .replyComments(replyComments)
                    .originComments(new CommentsEntity())
                    .build();
        }else{
            CommentsEntity originCommentsEntity = new CommentsEntity();
            Comments originComments = commentsMapper.selectByPrimaryKey(comments.getToId());
            UserInfo toInfo = userInfoMapper.selectByPrimaryKey(originComments.getFromId());
            String toName = toInfo.getName();
            String toAvatar = toInfo.getAvatar();

            originCommentsEntity.setUserName(toName);
            originCommentsEntity.setUserAvatar(toAvatar);

            BeanCopyUtils.copy(originComments,originCommentsEntity);
            return CommentsResponseResult.builder()
                    .replyComments(replyComments)
                    .originComments(originCommentsEntity)
                    .build();
        }

    }
}
