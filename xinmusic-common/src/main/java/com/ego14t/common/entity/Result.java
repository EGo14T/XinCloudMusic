package com.ego14t.common.entity;

import com.ego14t.common.constant.DataConsts;
import com.ego14t.common.error.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/28 15:55
 * Description:
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 2376756917440476778L;
    
    public static ResponseEntity<? extends ResultEntity> OK() {
        ResultEntity res = new ResultEntity();
        res.setCode(DataConsts.DEFAULT_SUCCESS_CODE);
        res.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    public static ResponseEntity<? extends ResultEntity> OK(Object data) {
        ResultEntity res = new ResultEntity();
        res.setData(data);
        res.setCode(DataConsts.DEFAULT_SUCCESS_CODE);
        res.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    public static ResponseEntity<? extends ResultEntity> ERROR(Integer code, String message) {
        ResultEntity res = new ResultEntity();
        res.setCode(code);
        res.setMessage(message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }

    public static ResponseEntity<? extends ResultEntity> ERROR(ErrorCode errorCode) {
        ResultEntity res = new ResultEntity();
        res.setCode(errorCode.getCode());
        res.setMessage(errorCode.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }
}
