package com.yiibo.gym.gateway.service;

import com.yiibo.gym.gateway.dto.AuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName: AuthenticationService
 * Description:
 * date: 2019/8/29 4:18 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
public interface AuthenticationService {

  public String signin(String username, String password);

  public void register(String username, String password);

}
