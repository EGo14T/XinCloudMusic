package com.ego14t.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XinmusicEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinmusicEurekaApplication.class, args);
    }

}
