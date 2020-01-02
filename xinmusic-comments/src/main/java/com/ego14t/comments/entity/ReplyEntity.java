package com.ego14t.comments.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/31 16:38
 * Description:
 */

@Data
public class ReplyEntity {
    private Integer id;
    private String commentId;
    private String fromId;
    private String fromName;
    private String fromAvatar;
    private String toId;
    private String toName;
    private String toAvatar;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

}
