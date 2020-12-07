package com.ego14t.comments.pojo;

import com.ego14t.comments.common.DataConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wangfx
 * @date 2020/12/7 15:30
 */
public class UserComment implements Serializable {
    private static final long serialVersionUID = -1437848214347436616L;

    /**
     * 被评论的资源ID musicId、musiclistId、commentsId
     */
    private String showId;

    /**
     * 评论用户的userId
     */
    private String fromUserId;

    /**
     * 被评论用户的userId
     */
    private String toUserId;

    /**
     * 子评论的父评论的主键ID
     */
    private String toId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 点赞数
     */
    private Integer like = 0;

    /**
     * 状态 1-有效 0-已删除
     */
    private Integer status = DataConsts.NORMAL_STATUS;

    private String nickname;

    private String avatar;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
