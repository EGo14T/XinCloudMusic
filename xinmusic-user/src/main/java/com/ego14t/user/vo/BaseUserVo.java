package com.ego14t.user.vo;

import com.ego14t.common.constant.vaildator.group.AddGroup;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/15 11:01
 * Description:
 */
public class BaseUserVo implements Serializable {
    private static final long serialVersionUID = -9084407225690769138L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 昵称
     */
    @NotBlank(groups = {AddGroup.class},message = "nickname不能为空")
    private String nickname;

    /**
     * 性别
     */
    @NotBlank(groups = {AddGroup.class},message = "gender不能为空")
    private Integer gender;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birth;

    /**
     * 地区
     */
    private String area;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
