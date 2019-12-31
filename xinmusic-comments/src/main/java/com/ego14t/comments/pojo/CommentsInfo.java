package com.ego14t.comments.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * comments_info
 * @author
 */
@Data
public class CommentsInfo implements Serializable {
    /**
     * 评论主键id
     */
    private String id;

    /**
     * 评论类型：对人评论，对项目评论，对资源评论
     */
    private Byte type;

    /**
     * 被评论者id，可以是人、项目、资源
     */
    private String ownerId;

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
     * 点赞的数量
     */
    private Integer likeNum;

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