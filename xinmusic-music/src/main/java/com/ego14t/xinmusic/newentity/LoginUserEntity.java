package com.ego14t.xinmusic.newentity;

/**
 * @author wangfx
 * @date 2020/11/13 12:01
 */
public class LoginUserEntity extends BaseEntity{

    private static final long serialVersionUID = 4470210963922573871L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 用户登录名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
