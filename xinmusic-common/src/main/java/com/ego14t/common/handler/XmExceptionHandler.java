package com.ego14t.common.handler;

import com.ego14t.common.entity.Result;
import com.ego14t.common.exception.XMException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 12:05
 * Description:
 */

@RestControllerAdvice
public class XmExceptionHandler {

    @ExceptionHandler(XMException.class)
    public Result handleXMException(XMException e) {
        return Result.error(e.getErrcode(),e.getErrmsg());
    }
}
