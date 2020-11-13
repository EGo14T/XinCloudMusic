package com.ego14t.xinmusic.newentity;

/**
 * @author wangfx
 * @date 2020/11/13 12:01
 */
public class CommentsEntity extends BaseEntity{

    private static final long serialVersionUID = -3464360210135273272L;

    /**
     * 评论内容的ID
     */
    private String showId;

    /**
     * 评论者ID （userid）
     */
    private String fromId;

    /**
     * 回复的评论的主键ID
     */
    private String toId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论点赞数
     */
    private Integer like;

    /**
     * 评论状态 1-有效 0-已删除
     */
    private Integer status;

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
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
}
