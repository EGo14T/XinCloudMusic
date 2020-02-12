package com.ego14t.comments.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/31 16:32
 * Description:
 */


@Data
public class CommentsInfoEntity {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private String ownerId;
    private String fromId;
    private String fromName;
    private String fromAvatar;
    private int likeNum;
    private String content;
    private ReplyEntity reply;
}
