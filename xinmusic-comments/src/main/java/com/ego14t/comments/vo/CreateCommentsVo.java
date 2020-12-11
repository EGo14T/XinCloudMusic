package com.ego14t.comments.vo;

import com.ego14t.common.constant.DataConsts;
import com.ego14t.common.constant.vaildator.group.AddGroup;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wangfx
 * @date 2020/12/1 14:36
 */
public class CreateCommentsVo implements Serializable {
    private static final long serialVersionUID = 6525107781568689165L;

    /**
     * 评论主键ID
     */
    private String id;

    /**
     * 被评论的资源ID musicId、musiclistId、commentsId
     */
    @NotBlank(groups = {AddGroup.class}, message = "评论的资源ID不能为空")
    private String showId;

    /**
     * 评论用户的userId
     */
    @NotBlank(groups = {AddGroup.class}, message = "评论用户的userId不能为空")
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
    @NotBlank(groups = {AddGroup.class}, message = "评论内容不能为空")
    private String content;

    /**
     * 点赞数
     */
    private Integer like;

    /**
     * 状态 1-有效 0-已删除
     */
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
