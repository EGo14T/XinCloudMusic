package com.ego14t.feign.vo;

import com.ego14t.feign.pojo.UserComment;

import java.io.Serializable;

public class CommentsResponseVo implements Serializable {

    private static final long serialVersionUID = -3719852185349740503L;
    /**
     * 评论内容
     */
    private UserComment replyComments;

    /**
     * 原评论 若toId不为null 则需要查询原评论内容 即灰色框的评论
     */
    private UserComment originComments;

    public UserComment getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(UserComment replyComments) {
        this.replyComments = replyComments;
    }

    public UserComment getOriginComments() {
        return originComments;
    }

    public void setOriginComments(UserComment originComments) {
        this.originComments = originComments;
    }

    public CommentsResponseVo(){}
}
