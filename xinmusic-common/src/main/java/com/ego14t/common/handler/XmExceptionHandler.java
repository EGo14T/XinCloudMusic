package com.ego14t.common.handler;

import com.ego14t.common.entity.Result;
import com.ego14t.common.error.ErrorCode;
import com.ego14t.common.exception.XMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    private static Logger logger = LoggerFactory.getLogger(XmExceptionHandler.class);

    /**
     * 业务流程异常
     * @param e XMException
     * @return errmsg
     */
    @ExceptionHandler(XMException.class)
    public ResponseEntity<?> handleXMException(XMException e) {
        return Result.ERROR(e.getErrcode(),e.getErrmsg());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return Result.ERROR(ErrorCode.NOT_JSON_DATA);
    }

    /**
     * 数据库唯一性约束异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> handleDuplicateKeyException(DuplicateKeyException e) {
        return Result.ERROR(ErrorCode.EXISTS_DATA);
    }

    /**
     * 其他未知Throwable
     * @param t Throwable
     * @return errmsg
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleThrowable(Throwable t) {
        logger.error(t.getMessage(),t);
        return Result.ERROR(ErrorCode.ERROR);
    }


//    private String getLogId() {
//
//    }
}
