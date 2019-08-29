package com.yiibo.gym.gateway.security;

import com.yiibo.gym.gateway.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * ClassName: CustomUserDetailsService
 * Description:
 * date: 2019/8/27 5:54 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{
  private UserRepository users;

  public CustomUserDetailsService(UserRepository users) {
    this.users = users;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.users.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
  }
}
