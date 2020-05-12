package com.ego14t.user.entity;

import com.ego14t.user.pojo.User;
import lombok.Data;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/12
 * Description:
 */
@Data
public class RegisterUser extends User {
    //昵称
    private String nickName;
}
