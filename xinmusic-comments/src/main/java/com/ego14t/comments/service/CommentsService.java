package com.ego14t.comments.service;

import com.ego14t.comments.entity.CommentsEntity;
import com.ego14t.comments.entity.CommentsResponseResult;
import com.ego14t.comments.pojo.Comments;

import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/30 17:17
 * Description:
 */
public interface CommentsService {
    CommentsResponseResult saveComments(Comments comments);
}
