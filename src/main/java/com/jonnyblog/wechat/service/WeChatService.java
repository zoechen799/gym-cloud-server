package com.jonnyblog.wechat.service;

import com.jonnyblog.wechat.model.entity.message.AccessToken;
/**
 * 微信公共服务类
 *
 */
public interface WeChatService {
	/**
	 * 获取基础支持接口凭证
	 */
	public AccessToken getAccessToken(String appId, String secret);

}
