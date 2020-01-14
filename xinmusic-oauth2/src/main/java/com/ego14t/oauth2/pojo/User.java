package com.ego14t.oauth2.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comments_info
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 评论主键id
     */
    private String id;

    /**
     * 评论类型：2：对人评论，1：对项目评论，0：对资源评论
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
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}