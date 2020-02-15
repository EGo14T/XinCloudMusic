package com.ego14t.comments.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * comments
 * @author
 */
@Data
@Builder
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

    private static final long serialVersionUID = 1L;

    @Tolerate
    public Comments(){}
}