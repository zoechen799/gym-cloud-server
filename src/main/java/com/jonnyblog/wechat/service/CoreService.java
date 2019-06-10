package com.jonnyblog.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 核心服务类
 *
 */
public interface CoreService {
	
    public  String processRequest(HttpServletRequest request);

}
