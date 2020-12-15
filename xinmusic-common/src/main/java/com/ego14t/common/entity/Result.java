package com.ego14t.common.entity;

import com.ego14t.common.error.ServiceErrors;

import java.io.Serializable;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 10:32
 * Description:
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -437797791789260731L;

    private Object data;

    private Integer code;

    private String message;

    public Result() {}

    public static Result ok() {
        Result result = new Result();
        result.code = 0;
        result.message = "success";
        return result;
    }

    public static Result ok(Object data) {
        Result result = new Result();
        result.code = 0;
        result.message = "success";
        result.data = data;
        return result;
    }

    public static Result ok(Object data, String message) {
        Result result = new Result();
        result.code = 0;
        result.message = message;
        result.data = data;
        return result;
    }

    public static Result error(ServiceErrors errors) {
        Result result = new Result();
        result.code = errors.getCode();
        result.message = errors.getMessage();
        return result;
    }

    public static Result error(ServiceErrors errors, Object data) {
        Result result = new Result();
        result.code = errors.getCode();
        result.message = errors.getMessage();
        result.data = data;
        return result;
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.code = code;
        result.message = message;
        return result;
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
