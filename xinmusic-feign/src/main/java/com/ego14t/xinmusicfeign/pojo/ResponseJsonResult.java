package com.ego14t.xinmusicfeign.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Create by EGo1ST on 2019/7/25
 * 说明：
 */

@Data
@ToString
public class ResponseJsonResult<T> {

    private String msg;
    private T data;

    public static <T> ResponseEntity<?> OK(T data, String msg){
        return result(data,HttpStatus.BAD_GATEWAY,msg);
    }

    public static <T> ResponseEntity<?> NOT_FOUND(T data, String msg){
        return result(data,HttpStatus.NOT_FOUND,msg);
    }



    //第一个<T> 声明该方法是一个泛型方法
    //ResponseJsonResult<T> 返回值类型
    //result 方法名
    private static <T> ResponseEntity<?> result(T data, HttpStatus status, String msg){
        ResponseJsonResult<T> apiRes = new ResponseJsonResult<>();
        apiRes.setMsg(msg);
        apiRes.setData(data);
        return new ResponseEntity<>(apiRes,status);
    }
}

