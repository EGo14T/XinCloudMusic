package com.ego14t.comments.service;

import com.ego14t.comments.pojo.CommentsInfo;
import com.ego14t.comments.pojo.CommentsReply;

import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/30 17:17
 * Description:
 */
public interface CommentsService {
    String saveComments(CommentsInfo commentsInfo);
    List<CommentsInfo> findByOwnerId(String ownerId);
    String saveReplay(CommentsReply commentsReply);
}
