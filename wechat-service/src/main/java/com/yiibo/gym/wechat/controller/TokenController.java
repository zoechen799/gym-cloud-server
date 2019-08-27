package com.yiibo.gym.wechat.controller;

import com.yiibo.gym.wechat.model.WxUserSession;
import com.yiibo.gym.wechat.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: TokenController
 * Description:
 * date: 2019/8/13 2:32 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@RestController
@RequestMapping("/token")
@Api(description = "微信小程序Token服务")
public class TokenController {
  @Autowired
  private TokenService tokenService;


  @GetMapping("/getOpenId")
  @ApiOperation(notes = "/getOpenId", httpMethod = "GET", value = "获取用户微信登录信息")
  @ResponseBody
  public ResponseEntity<WxUserSession> getOpenId (@ApiParam(value = "微信用户 Code") @RequestParam String code) {
    HttpHeaders headers = new HttpHeaders();
    WxUserSession session = tokenService.getOpenId(code);
    if(session != null){
      return new ResponseEntity<WxUserSession>(session, headers, HttpStatus.OK);
    }else{
      return new ResponseEntity<WxUserSession>(null, headers, HttpStatus.UNAUTHORIZED);
    }
  }
}
