package com.yiibo.gym.gateway.controller;


import com.yiibo.gym.gateway.dto.AuthenticationRequest;
import com.yiibo.gym.gateway.service.AuthenticationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

/**
 * ClassName: AuthenticationController
 * Description:
 * date: 2019/8/27 5:52 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@RestController
@RequestMapping("/auth")
@Api(description = "统一授权认证")
public class AuthenticationController {

  @Autowired
  AuthenticationService authenticationService;


  @PostMapping("/signin")
  public ResponseEntity signin(@RequestBody AuthenticationRequest data) {

    try {
      String token = authenticationService.signin(data.getUsername(), data.getPassword());

      Map<Object, Object> model = new HashMap<>();
      model.put("token", token);
      return ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied");
    }
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody AuthenticationRequest data) {
    authenticationService.register(data.getUsername(), data.getPassword());
    Map<Object, Object> model = new HashMap<>();
    return ok(model);
  }

}
