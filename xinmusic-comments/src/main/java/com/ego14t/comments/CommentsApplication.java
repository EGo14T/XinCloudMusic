package com.ego14t.comments;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ego14t.comments.mapper")
public class CommentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentsApplication.class, args);
    }

}
