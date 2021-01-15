package com.ego14t.xinmusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author EGo1ST
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.ego14t.*")
@EnableSwagger2
@MapperScan({"com.ego14t.xinmusic.mapper","com.ego14t.xinmusic.newmapper"})

public class XinmusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinmusicApplication.class, args);
    }

}
