package com.yiibo.gym.gateway.service.impl;

import com.yiibo.gym.gateway.model.Role;
import com.yiibo.gym.gateway.model.User;
import com.yiibo.gym.gateway.repository.UserRepository;
import com.yiibo.gym.gateway.security.jwt.JwtTokenProvider;
import com.yiibo.gym.gateway.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: AuthenticationServiceImpl
 * Description:
 * date: 2019/8/29 4:19 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Slf4j
@Service("AuthenticationService")
public class AuthenticationServiceImpl implements AuthenticationService{
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  UserRepository users;

  /**
   * sigin and generate token
   * @param username
   * @param password
   * @return
   */
  @Override
  public String signin(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

    String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"))
        .getRoles().stream().map(role -> role.getRole())
        .collect(Collectors.toList()));

    return token;
  }

  @Override
  public void register(String username, String password) throws BadCredentialsException {
    if(users.findByUsername(username).isPresent()){
      throw new BadCredentialsException("user already exist");
    }
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    Role role = new Role();
    role.setRole("ROLE_USER");
    role.setId(1);
    List<Role> roles = new ArrayList<Role>();

    user.setRoles(roles);
    users.save(user);
  }
}
