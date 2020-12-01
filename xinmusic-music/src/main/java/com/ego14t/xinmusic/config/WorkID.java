package com.ego14t.xinmusic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/5/12
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "workid")
public class WorkID implements Serializable {
    private static final long serialVersionUID = -9081991200616853728L;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
