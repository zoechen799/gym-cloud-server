package com.yiibo.gym.auth.config;

import com.yiibo.gym.auth.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * ClassName: WebSecurityConfig
 * Description: 用户认证配置
 * date: 2019/7/3 2:10 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
  @Autowired
  private UserDetailService userDetailService;

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests().antMatchers(
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/configuration/ui",
        "/swagger-resources/configuration/security").permitAll()
        .anyRequest().authenticated()
        .and().csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
