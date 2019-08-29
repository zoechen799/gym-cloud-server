package com.yiibo.gym.gateway.controller;


import com.yiibo.gym.gateway.dto.AuthenticationRequest;
import com.yiibo.gym.gateway.repository.UserRepository;
import com.yiibo.gym.gateway.security.jwt.JwtTokenProvider;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  UserRepository users;

  @PostMapping("/signin")
  public ResponseEntity signin(@RequestBody AuthenticationRequest data) {

    try {
      String username = data.getUsername();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));

      String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username)
          .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"))
          .getRoles().stream().map(role -> role.getRole())
          .collect(Collectors.toList()));

      Map<Object, Object> model = new HashMap<>();
      model.put("username", username);
      model.put("token", token);
      return ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied");
    }
  }

}
