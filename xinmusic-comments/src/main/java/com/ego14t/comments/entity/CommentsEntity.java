package com.ego14t.comments.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CommentsEntity {

    private String id;
    private String showId;
    private String fromId;
    private String toId;
    private String content;
    private Integer like = 0;
    private Integer state = 1;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 添加评论者头像和名称
     */

    private String userAvatar;

    private String userName;


}
