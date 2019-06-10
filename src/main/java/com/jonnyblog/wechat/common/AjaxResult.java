package com.jonnyblog.wechat.common;

import com.jonnyblog.wechat.common.enums.Code;
import com.jonnyblog.wechat.service.exception.ServiceException;

/**
 * Created by zihan.chen on 2017/6/14.
 */
public class AjaxResult {
    /**
     * 请求结果是否成功
     */
    private int ErrorCode = Code.SUCCESS.getCode();

    /**
     * 请求返回信息
     */
    private String Message = Constants.DEFAULT_SUCCESS_RETURNMSG;

    /**
     * 请求结果
     */
    private Object Data = null;


    /**
     * Instantiates a new Ajax result.
     */
    private AjaxResult(){}

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    /**
     * 获取正确结果模板
     *
     * @param message 请求返回信息
     * @param obj 请求结果
     * @return AjaxResult
     */
    public static AjaxResult getOK(String message, Object obj){
        AjaxResult result = new AjaxResult();
        result.setMessage(message);
        result.setData(obj);
        return result;
    }
    /**
     * 获取正确结果模板
     *
     * @param obj 请求结果
     * @return AjaxResult
     */
    public static AjaxResult getOK(Object obj){
        AjaxResult result = new AjaxResult();
        result.setMessage(Constants.DEFAULT_SUCCESS_RETURNMSG);
        result.setData(obj);
        return result;
    }

    /**
     * 获取错误结果模板
     *
     * @param message 请求返回信息
     * @param obj 请求结果
     * @return AjaxResult
     */
    public static AjaxResult getError(Code errorCode, String message, Object obj){
        AjaxResult result = new AjaxResult();
        result.setErrorCode(errorCode.getCode());
        result.setMessage(message);
        result.setData(obj);
        return result;
    }

    /**
     * 获取正确结果模板
     *
     * @return AjaxResult
     */
    public static AjaxResult getOK(){
        return getOK(Constants.DEFAULT_SUCCESS_RETURNMSG,null);
    }


    /**
     * 获取错误结果模板
     *
     * @return AjaxResult
     */
    public static AjaxResult getError(Code resultCode){
        return getError(resultCode, Constants.DEFAULT_FAILED_RETURNMSG, null);
    }

    /**
     * 根据ServiceException 生成结果模板
     * @param e exception
     * @return AjaxResult
     */
    public static AjaxResult getError(ServiceException e){
        return getError(e.getCode(), e.getMessage(), null);
    }

    /**
     *
     * @param e
     * @return
     */
    public static AjaxResult getGeneralError(Exception e){
        return getError(Code.ERROR, e.getMessage(), null);
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "ErrorCode='" + ErrorCode + '\'' +
                ", Message='" + Message + '\'' +
                ", Data=" + Data +
                '}';
    }
}
