package com.ego14t.comments.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class CommentsResponseResult {

    /**
     * 评论内容
     */
    private CommentsEntity replyComments;

    /**
     * 原评论 若toId不为null 则需要查询原评论内容 即灰色框的评论
     */
    private CommentsEntity originComments;

    @Tolerate
    public CommentsResponseResult(){}
}
