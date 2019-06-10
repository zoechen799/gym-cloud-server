package com.jonnyblog.wechat.service.exception;

import com.jonnyblog.wechat.common.enums.Code;

/**
 * Created by zihan.chen on 2017/1/13.
 */
public class ServiceException extends Exception{
    private static final long serialVersionUID = 1L;

    private Code code;

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Code code, String message) {
        super(message);
        this.setCode(code);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(Code code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
