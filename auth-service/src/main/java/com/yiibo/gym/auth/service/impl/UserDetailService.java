package com.yiibo.gym.auth.service.impl;

import com.yiibo.gym.auth.model.User;
import com.yiibo.gym.auth.repository.UserRepository;
import com.yiibo.gym.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ClassName: UserDetailService
 * Description:
 * date: 2019/7/3 2:28 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Service
public class UserDetailService implements UserDetailsService, UserService{
  private final Logger logger = LoggerFactory.getLogger(getClass());

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
  }

  @Override
  public void create(User user){
    Optional<User> existing = repository.findByUsername(user.getUsername());
    existing.ifPresent(it -> {
      throw new IllegalArgumentException("用户已经存在: " + it.getUsername());
    });

    String encodedPwd = encoder.encode(user.getPassword());
    user.setPassword(encodedPwd);

    repository.saveAndFlush(user);

    logger.info("new user has been created: {}", user.getUsername());
  }
}
