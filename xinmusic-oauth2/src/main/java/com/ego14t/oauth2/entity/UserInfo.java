package com.ego14t.oauth2.entity;

import com.ego14t.common.entity.BaseEntity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/19 17:26
 * Description:
 */
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -850465471888632654L;

    private String userid;

    private String nickname;

    private Integer gender;

    private String introduce;

    private LocalDate birth;

    private String area;

    private String avatar;

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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
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
}
