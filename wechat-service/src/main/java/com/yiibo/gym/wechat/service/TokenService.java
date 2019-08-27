package com.yiibo.gym.wechat.service;

import com.yiibo.gym.wechat.model.WxUserSession;

/**
 * ClassName: TokenService
 * Description:
 * date: 2019/8/13 2:37 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
public interface TokenService {
  public WxUserSession getOpenId(String code);
}
