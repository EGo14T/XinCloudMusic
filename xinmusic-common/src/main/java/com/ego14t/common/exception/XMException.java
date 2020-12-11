package com.ego14t.common.exception;

import com.ego14t.common.constant.DataConsts;
import com.ego14t.common.error.ServiceErrors;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2020/12/11 11:58
 * Description:
 */
public class XMException extends RuntimeException{
    private static final long serialVersionUID = -2703579004268061583L;

    private String errmsg;

    private int errcode;

    public XMException(String errmsg) {
        super(errmsg);
        this.setErrmsg(errmsg);
    }

    public XMException(ServiceErrors errors) {
        super(errors.getMessage(),null,false,false);
        this.setErrmsg(errors.getMessage());
        this.errcode = errors.getCode();
    }

    public XMException(String errmsg, Throwable e) {
        super(errmsg, e);
        this.setErrmsg(errmsg);
    }

    public XMException(String errmsg, Integer errcode) {
        super(errmsg);
        this.setErrmsg(errmsg);
        this.errcode = errcode;
    }

    public XMException(String errmsg, Integer errcode, Throwable e) {
        super(errmsg, e);
        this.setErrmsg(errmsg);
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
