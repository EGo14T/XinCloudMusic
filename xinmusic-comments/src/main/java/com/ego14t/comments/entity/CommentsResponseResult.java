package com.ego14t.comments.entity;

public class CommentsResponseResult {

    /**
     * 评论内容
     */
    private CommentsEntity replyComments;

    /**
     * 原评论 若toId不为null 则需要查询原评论内容 即灰色框的评论
     */
    private CommentsEntity originComments;

    public CommentsEntity getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(CommentsEntity replyComments) {
        this.replyComments = replyComments;
    }

    public CommentsEntity getOriginComments() {
        return originComments;
    }

    public void setOriginComments(CommentsEntity originComments) {
        this.originComments = originComments;
    }

    public CommentsResponseResult(){}
}
