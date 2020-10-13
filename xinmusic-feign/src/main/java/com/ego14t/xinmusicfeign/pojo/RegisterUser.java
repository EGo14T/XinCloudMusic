package com.ego14t.xinmusicfeign.pojo;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/12
 * Description:
 */
public class RegisterUser extends User {
    //昵称
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
