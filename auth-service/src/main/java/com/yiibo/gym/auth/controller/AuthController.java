package com.yiibo.gym.auth.controller;

import com.yiibo.gym.auth.model.User;
import com.yiibo.gym.auth.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * ClassName: AuthController
 * Description:
 * date: 2019/7/3 3:05 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private UserDetailService userDetailService;

  @GetMapping("/currentUser")
  public Principal getCurrentUser(Principal principal){
    return principal;
  }

  @PreAuthorize("#oauth2.hasScope('server')")
  @PostMapping("/create")
  public void createUser(@Valid @RequestBody User user){
    userDetailService.create(user);
  }

  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }
}
