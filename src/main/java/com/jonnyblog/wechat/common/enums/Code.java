package com.jonnyblog.wechat.common.enums;

/**
 * Created by zihan.chen on 2017/1/13.
 * Code 规范：
 * 		1XXXX: 业务处理过程中发生错误
 * 		2XXXX: 调用者方调用方式有误
 * 		3XXXX: 与业务无关的其他错误
 * 		4XXXX: 系统错误
 */
public enum Code {
    SUCCESS(0),
    /**
     * 业务失败
     */
    BUSINESS_FAIL(10000),

    /**
     * 参数有误
     */
    PARAM_ERROR(20000),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND(20001),

    /**
     * 不允许操作
     */
    OPERATION_IS_NOT_ALLOWED(20016),
    /**
     * 没有该记录
     */
    RECORD_NOT_EXIST(20023),
    /**
     * 文件不存在
     */
    FILE_NOT_EXIST(20023),

    /**
     * 用户未登录
     */
    UNLOGIN(30001),

    /**
     * 用户验证失败
     */
    USER_AUTHENTICATION_FAIL(30002),


    /**
     * 会话已过期
     */
    SESSION_TIMEOUT(30003),
    /**
     * token已过期
     */
    TOKEN_TIMEOUT(30004),
    /**
     * token已失效
     */
    TOKEN_INVALID(30005),

    /**
     * 请求超时
     */
    REQUEST_TIMEOUT(30004),

    /**
     * 系统异常
     */
    ERROR(40000),

    /**
     * 未知异常
     */
    UN_KNOWN_EXCEPTION(40001),

    /**
     * 短信服务异常
     */
    SMS_API_EXCEPTION(40002);

    //注册错误
    public static final String VCODE_NOT_VALID_MSG = "验证码无效";
    public static final String VCODE_EXPIRED_MSG = "验证码已过期，请重新获取验证码。";
    public static final String PHONE_HAS_REGIST_MSG = "该手机号已被注册";

    //登录错误
    public static final String INVALID_MOBILE_MSG = "手机格式错误";
    public static final String INVALID_PASSWORD_MSG = "密码格式错误";
    public static final String PHONE_NOT_EXIST_MSG = "该用户不存在";
    public static final String PASSWORD_VALID_MSG = "密码错误,请重新输入";

    //重置密码
    public static final String NOT_GET_VCODE_MSG = "请点击获取验证码";


    /**
     * 状态码
     */
    private int code;

    private Code(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
