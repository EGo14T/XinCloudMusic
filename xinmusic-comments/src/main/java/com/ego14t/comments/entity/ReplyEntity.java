package com.ego14t.comments.entity;

import lombok.Data;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2019/12/31 16:38
 * Description:
 */

@Data
public class ReplyEntity {
    private String toId;
    private String date;
    private String toName;
    private String toAvatar;
    private String fromName;
    private String commentId;
    private String id;
    private String fromId;
    private String fromAvatar;
    private String content;

}
