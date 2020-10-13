package com.ego14t.xinmusic.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by EGo1ST on 2019/7/25
 * 说明：
 */

public class ResponseJsonResult {

    private int status = 200;
    private String msg;
    private Object obj;
    private List<?> list = new ArrayList<Object>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}

