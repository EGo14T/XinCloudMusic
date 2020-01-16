package com.ego14t.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author EGo1ST
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Oauth2Application {
    public static void main(String[] args) {
        System.out.println("加密后"+new BCryptPasswordEncoder().encode("test"));
        SpringApplication.run(Oauth2Application.class, args);
    }
}
