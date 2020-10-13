package com.ego14t.xinmusicfeign.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * comments
 * @author
 */
public class Comments implements Serializable {
    /**
     * 评论主键ID
     */
    private String id;

    /**
     * 评论的内容id 如歌曲资源ID
     */
    private String showId;

    /**
     * 评论者id 是谁评论的
     */
    private String fromId;

    /**
     * 被评论的id
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
     * 状态：1：有效  0：已删除
     */
    private Integer state = 1;

    /**
     * 评论时间
     */
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    private static final long serialVersionUID = 1L;
}