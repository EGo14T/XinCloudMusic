package com.ego14t.oauth2.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Create by EGo1ST on 2019/12/27
 * 说明： 封装的返回值静态方法
 */

@Data
@ToString
public class ResponseJsonResult<T> {

    private String msg;
    private T data;

    public static <T> ResponseEntity<?> OK(T data, String msg){
        return result(data,HttpStatus.OK,msg);
    }

    public static <T> ResponseEntity<?> CREATED(T data, String msg){
        return result(data,HttpStatus.CREATED,msg);
    }

    public static <T> ResponseEntity<?> NO_CONTENT(T data, String msg){
        return result(data,HttpStatus.NO_CONTENT,msg);
    }

    public static <T> ResponseEntity<?> UNAUTHORIZED(T data, String msg){
        return result(data,HttpStatus.UNAUTHORIZED,msg);
    }

    public static <T> ResponseEntity<?> NOT_FOUND(T data, String msg){
        return result(data,HttpStatus.NOT_FOUND,msg);
    }

    public static <T> ResponseEntity<?> METHOD_NOT_ALLOWED(T data, String msg){
        return result(data,HttpStatus.METHOD_NOT_ALLOWED,msg);
    }

    public static <T> ResponseEntity<?> INTERNAL_SERVER_ERROR(T data, String msg){
        return result(data,HttpStatus.INTERNAL_SERVER_ERROR,msg);
    }


    //第一个<T> 声明该方法是一个泛型方法
    //ResponseEntity<?> 返回值类型
    //result 方法名
    private static <T> ResponseEntity<?> result(T data, HttpStatus status, String msg){
        ResponseJsonResult<T> apiRes = new ResponseJsonResult<>();
        apiRes.setMsg(msg);
        apiRes.setData(data);
        return new ResponseEntity<>(apiRes,status);
    }
}

