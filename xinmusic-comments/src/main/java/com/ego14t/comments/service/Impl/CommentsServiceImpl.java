package com.ego14t.comments.service.Impl;

import com.ego14t.comments.mapper.CommentsInfoMapper;
import com.ego14t.comments.pojo.CommentsInfo;
import com.ego14t.comments.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


    @Override
    public String saveComments(CommentsInfo commentsInfo) {
        commentsInfoMapper.insertSelective(commentsInfo);
        return commentsInfo.getId();
    }
}
