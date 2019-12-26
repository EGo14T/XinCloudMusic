package com.ego14t.xinmusicfeign.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by EGo1ST on 2019/7/25
 * 说明：
 */

@Data
@Builder(toBuilder = true)
public class ResponseJsonResult {

    private int status = 200;
    private String msg;
    private Object obj;
    private List<?> list = new ArrayList<>();
}

