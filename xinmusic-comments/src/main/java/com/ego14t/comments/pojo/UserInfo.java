package com.ego14t.comments.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * user_info
 * @author 
 */
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
    private Date birth;

    /**
     * 用户所在地区
     */
    private String area;

    /**
     * 用户头像
     */
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    private static final long serialVersionUID = 1L;
}