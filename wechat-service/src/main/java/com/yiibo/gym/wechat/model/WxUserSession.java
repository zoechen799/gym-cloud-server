package com.yiibo.gym.wechat.model;

import lombok.Data;

/**
 * ClassName: WxUserSession
 * Description:
 * date: 2019/8/13 2:37 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Data
public class WxUserSession {
  private String session_key;

  private String openid;

  private String unionid;

  private String errcode;

  private String errmsg;
}
