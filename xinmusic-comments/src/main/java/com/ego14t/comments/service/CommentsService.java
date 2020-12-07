package com.ego14t.comments.service;

import com.ego14t.comments.vo.CommentsResponseVo;
import com.ego14t.comments.vo.CreateCommentsVo;

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
     * @param createCommentsVo 评论vo
     * @param fromUserId 创建人
     * @return 新建评论的ID
     */
    String saveComments(CreateCommentsVo createCommentsVo, String fromUserId);

    CommentsResponseVo getComment(String commentId, String userid);

    List<CommentsResponseVo> getAllComments(String showId, Integer page, Integer total);
}
