package com.ego14t.user.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * user_info
 * @author 
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户的唯一ID标识
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户性别 0:保密 1:男 2:女
     */
    private Integer gender;

    /**
     * 用户个人介绍
     */
    private String introduce;

    /**
     * 用户的生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    /**
     * 用户所在地区
     */
    private String area;

    /**
     * 用户头像
     */
    private String avatar;

    private static final long serialVersionUID = 1L;
}