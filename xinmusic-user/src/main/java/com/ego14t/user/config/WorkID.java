package com.ego14t.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/12
 * Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "workid")
public class WorkID {
    private int user;
    private int music;
    private int musiclist;
    private int comments;
}
