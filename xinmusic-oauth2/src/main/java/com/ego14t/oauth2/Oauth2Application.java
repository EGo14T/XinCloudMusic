package com.ego14t.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 认证服务器，用于获取 Token
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-04-01 16:06:45
 * @see com.ego14t.oauth2
 */
@SpringBootApplication
public class Oauth2Application {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
        SpringApplication.run(Oauth2Application.class, args);
    }



}
