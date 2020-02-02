package com.ego14t.xinmusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author EGo1ST
 */
@EnableEurekaClient
@SpringBootApplication
@EnableCaching
@MapperScan("com.ego14t.xinmusic.mapper")
public class XinmusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinmusicApplication.class, args);
    }

}
