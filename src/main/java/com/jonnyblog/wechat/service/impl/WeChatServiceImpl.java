package com.jonnyblog.wechat.service.impl;

import java.sql.Timestamp;

import com.jonnyblog.wechat.common.Constants;
import com.jonnyblog.wechat.dao.AccesstokenRepository;
import com.jonnyblog.wechat.model.Accesstoken;
import com.jonnyblog.wechat.model.entity.message.AccessToken;
import com.jonnyblog.wechat.service.WeChatService;
import com.jonnyblog.wechat.util.HttpUtil;
import com.jonnyblog.wechat.util.ToolUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * ClassName: WeChatServiceImpl
 * Description:
 * date: 2019/6/10 11:09 AM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {
  private static Logger log = LoggerFactory.getLogger(WeChatServiceImpl.class);
  private static String REFRESH_FLAG = "";
  // 基础支持授权获取access_token的接口地址（GET） 限2000（次/天）
  public final static String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

  @Autowired
  AccesstokenRepository accesstokenRepository;

  @Override
  public AccessToken getAccessToken(String appId, String secret) {
    AccessToken result = new AccessToken();
    Accesstoken dbToken = getAccessTokenFromDb(appId, secret);
    if(dbToken == null) {
      dbToken = new Accesstoken();
      dbToken.setChannle(Constants.CHANNLE);
      dbToken.setGranttype(Constants.GRANTTYPE_CLIENT_CREDENTIAL);
      dbToken.setAppid(appId) ; //Constants.APP_ID);
      dbToken.setSecret(secret); //(Constants.APP_SECRET);
    }else if(dbToken.getExpires() == 0) {//其它线程或进程正在刷新，等待重新获取
      dbToken = retryGetAccessTokenFromDb(appId, secret, 5);
    }
    boolean needRefresh = !checkAccessToken(dbToken);
    if(needRefresh) {
      synchronized(REFRESH_FLAG) {
        dbToken.setExpires(0);
        accesstokenRepository.saveAndFlush(dbToken);
        result = retryGetAccessTokenFromWx(appId, secret, 3);
        if(result != null) {
          Timestamp createTime = new Timestamp(System.currentTimeMillis());
          dbToken.setAccesstoken(result.getAccessToken());
          dbToken.setCreatetime(createTime);
          dbToken.setExpires(result.getExpiresIn());
          accesstokenRepository.saveAndFlush(dbToken);
          log.info("更新access_token: for appid {} {}", appId, dbToken.getAccesstoken());
        }
      }
    }else {
      result.setAccessToken(dbToken.getAccesstoken());
      result.setExpiresIn(dbToken.getExpires());;
    }
    return result;
  }

  /**
   * 从数据库加载access_token
   * @return
   */
  private Accesstoken getAccessTokenFromDb(String appId, String secret) {
    Accesstoken dbToken = accesstokenRepository.findByAppidAndSecret(appId, secret); //accesstokenRepository.findOne(Constants.CHANNLE);
    return dbToken;
  }

  /**
   * 从微信公众号平台获取access_token
   * @return
   */
  private AccessToken getAccessTokenFromWx(String appId, String secret) {
    String requestUrl = URL_ACCESS_TOKEN.replace("APPID", appId).replace("APPSECRET", secret);
    String result = HttpUtil.httpsRequest(requestUrl, "GET", null, true);
    if(StringUtils.isEmpty(result)) {
      log.error("基础支持access_toke获取https请求失败：{}", requestUrl);
      return null;
    }
    JSONObject jsonObject = null;
    try {
      jsonObject = JSONObject.fromObject(result);
    } catch (JSONException e) {
      log.error("基础支持access_token获取结果异常 {}", result);
    }
    if (null != jsonObject) {
      try {
        return new AccessToken(jsonObject.getString("access_token"), jsonObject.getInt("expires_in"));
      } catch (JSONException e) {
        log.error("基础支持access_token获取结果异常 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
      }
    }
    return null;
  }

  /**
   * 从公众号平台获取access_token重试
   *
   * @param count 等待1s
   * @return
   */
  private AccessToken retryGetAccessTokenFromWx(String appId, String secret, int count) {
    AccessToken token = null;
    try {
      for(int i=0; i< count;i++) {
        token = getAccessTokenFromWx(appId, secret);
        if(token != null) break;
        Thread.sleep(1000);
      }
    } catch (Exception e) {
      log.error(ToolUtil.getStackTrace(e));
      return null;
    }
    return token;
  }

  /**
   * 等待其它线程或进程刷新access_token
   *
   * @param count 每次等待2s
   * @return
   */
  private Accesstoken retryGetAccessTokenFromDb(String appId, String secret, int count) {
    Accesstoken token = null;
    try {
      for(int i=0; i< count;i++) {
        token = getAccessTokenFromDb(appId, secret);
        if(token != null && token.getExpires() != 0) break;
        Thread.sleep(2000);
      }
    } catch (Exception e) {
      log.error(ToolUtil.getStackTrace(e));
      return null;
    }
    return token;
  }

  /**
   * 校验access_token是否可用
   * @param token
   * @return
   */
  private boolean checkAccessToken(Accesstoken token) {
    if(token == null) return false;
    String accessToken = token.getAccesstoken();
    Timestamp createTime = token.getCreatetime();
    Integer expires = token.getExpires();
    if(StringUtils.isEmpty(accessToken) || createTime == null || expires == null) return false;
    return !isExpired(token);
  }

  /**
   * 检查是否过期（提前10分钟）
   *
   * @param token
   * @return
   */
  private boolean isExpired(Accesstoken token) {
    if(token.getExpires() == 0) return true;
    return (System.currentTimeMillis()- token.getCreatetime().getTime()) > (token.getExpires() * 1000 - 600 * 1000);
  }

}
