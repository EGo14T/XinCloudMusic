package com.ego14t.common.entity;

import com.ego14t.common.constant.DataConsts;
import com.ego14t.common.error.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/28 15:55
 * Description:
 */
public class Result<T> extends ResponseEntity<T> {

    public Result(HttpStatus status) {
        super(status);
    }

    public Result(HttpStatus status, T data) {
        super(data, status);
    }

    public static Result<?> OK() {
        ResultEntity res = new ResultEntity();
        res.setCode(DataConsts.DEFAULT_SUCCESS_CODE);
        res.setMessage("success");
        return new Result<>(HttpStatus.OK, res);
    }

    public static Result<?> OK(Object data) {
        ResultEntity res = new ResultEntity();
        res.setData(data);
        res.setCode(DataConsts.DEFAULT_SUCCESS_CODE);
        res.setMessage("success");
        return new Result<>(HttpStatus.OK, res);
    }

    public static Result<?> ERROR(Integer code, String message) {
        ResultEntity res = new ResultEntity();
        res.setCode(code);
        res.setMessage(message);
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR, res);
    }

    public static Result<?> ERROR(ErrorCode errorCode) {
        ResultEntity res = new ResultEntity();
        res.setCode(errorCode.getCode());
        res.setMessage(errorCode.getMessage());
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR, res);
    }


}
