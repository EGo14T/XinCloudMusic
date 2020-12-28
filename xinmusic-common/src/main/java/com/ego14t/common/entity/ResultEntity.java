package com.ego14t.common.entity;

import com.ego14t.common.error.ServiceErrors;

import java.io.Serializable;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 10:32
 * Description:
 */
public class ResultEntity implements Serializable {
    private static final long serialVersionUID = -437797791789260731L;

    private Object data;

    private Integer code;

    private String message;

    public ResultEntity() {}

    public static ResultEntity ok() {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.code = 0;
        resultEntity.message = "success";
        return resultEntity;
    }

    public static ResultEntity ok(Object data) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.code = 0;
        resultEntity.message = "success";
        resultEntity.data = data;
        return resultEntity;
    }

    public static ResultEntity ok(Object data, String message) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.code = 0;
        resultEntity.message = message;
        resultEntity.data = data;
        return resultEntity;
    }

    public static ResultEntity error(ServiceErrors errors) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.code = errors.getCode();
        resultEntity.message = errors.getMessage();
        return resultEntity;
    }

    public static ResultEntity error(ServiceErrors errors, Object data) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.code = errors.getCode();
        resultEntity.message = errors.getMessage();
        resultEntity.data = data;
        return resultEntity;
    }

    public static ResultEntity error(Integer code, String message) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.code = code;
        resultEntity.message = message;
        return resultEntity;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
