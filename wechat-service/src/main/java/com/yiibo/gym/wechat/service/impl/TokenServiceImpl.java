package com.yiibo.gym.wechat.service.impl;

import com.yiibo.gym.wechat.model.WxUserSession;
import com.yiibo.gym.wechat.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: TokenServiceImpl
 * Description:
 * date: 2019/8/13 2:39 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Slf4j
@Service("TokenService")
public class TokenServiceImpl implements TokenService{

  @Value("${wechat.app-id}")
  public String appId;

  @Value("${wechat.app-secret}")
  public String appSecret;

  @Override
  public WxUserSession getOpenId(String code) {
    RestTemplate restTemplate = new RestTemplate();
    WxUserSession userSession = new WxUserSession();
    try {
      log.info("getOpenId with Code: " +code);
      String response = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=" +
          appId + "&secret=" +
          appSecret + "&js_code=" +
          code + "&grant_type=authorization_code", String.class);
      log.info(">>> response from weixin: " + response);
      JSONObject object = JSONObject.fromObject(response);
      if(object != null){
        if(object.containsKey("errcode")){
          userSession.setErrcode(object.getString("errcode"));
          if(object.containsKey("errmsg")){
            userSession.setErrmsg(object.getString("errmsg"));
          }
          return userSession;
        }else{
          if(object.containsKey("openid")){
            userSession.setOpenid(object.getString("openid"));
          }
          if(object.containsKey("session_key")){
            userSession.setSession_key(object.getString("session_key"));
          }
          if(object.containsKey("unionid")){
            userSession.setUnionid(object.getString("unionid"));
          }
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    return userSession;
  }
}
