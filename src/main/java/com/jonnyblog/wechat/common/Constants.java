package com.jonnyblog.wechat.common;

/**
 * Created by zihan.chen on 2017/6/14.
 */
public class Constants {
	/**
	 * 微信公众号信息
	 */
	public static String APP_ID = "wxb4c109d4162b1884";
    public static String APP_SECRET = "0e5643617fd5bea16cbd6972189ab4dd";
    public static String WECHAT_TOKEN = "";
    /**
     * 授权配置KEY
     */
    public static final String GRANTTYPE_CLIENT_CREDENTIAL = "client_credential";
    public static final String SCOPE_SNSAPI_BASE = "snsapi_base";
    /**
	 * 小草微信公众号渠道标识
	 */
    public static String CHANNLE = "";


    /**
     * 当前登录用户SESSION KEY
     */
    public static final String SESSION_USER = "SESSION_USER";
    /**
     * 当前登录用户的SESSION TOKEN KEY
     */
    public static final String SESSION_USER_TOKEN = "SESSION_USER_TOKEN";
    /**
     * 当前用户获取的验证码
     */
    public static final String SESSION_VERIFICATION_CODE ="SESSION_VERIFICATION_CODE";

    public static final String DEFAULT_SUCCESS_RETURNMSG = "Succeed";

    public static final String DEFAULT_FAILED_RETURNMSG = "Failed";

    public static final String URL_WX = "http://gym.jonnyblog.com";
}
