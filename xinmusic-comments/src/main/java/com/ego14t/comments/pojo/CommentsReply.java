package com.ego14t.comments.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * comments_reply
 * @author 
 */
@Data
public class CommentsReply implements Serializable {

    private Integer id;

    /**
     * 评论主表id
     */
    private String commentId;

    /**
     * 评论者id
     */
    private String fromId;

    /**
     * 评论者名字
     */
    private String fromName;

    /**
     * 评论者头像
     */
    private String fromAvatar;

    /**
     * 被评论者id
     */
    private String toId;

    /**
     * 被评论者名字
     */
    private String toName;

    /**
     * 被评论者头像
     */
    private String toAvatar;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}