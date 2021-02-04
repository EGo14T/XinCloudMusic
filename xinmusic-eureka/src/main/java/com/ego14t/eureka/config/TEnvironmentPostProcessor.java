package com.ego14t.eureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.boot.env.EnvironmentPostProcessor;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/2/3 9:31
 * Description:
 */
public class TEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String isTest = environment.getProperty("xinmusic.isTest");
        System.out.println(isTest);
    }
}
