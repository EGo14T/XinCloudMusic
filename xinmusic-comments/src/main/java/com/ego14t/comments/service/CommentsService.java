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
    /**
     * 新增评论
     * @param comments 评论实体
     * @return 该条评论
     */
    CommentsResponseResult saveComments(Comments comments);

    List<CommentsResponseResult> getComments(String showId, Integer page, Integer total);
}
