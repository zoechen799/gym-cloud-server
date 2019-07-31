package com.yiibo.gym.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ResourceServerConfig
 * Description:
 * date: 2019/7/30 2:20 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers(antMatchersPermitAll()).permitAll()
        // 异常处理
        .and().exceptionHandling()
        .and().httpBasic();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    // 定义异常转换类生效
    OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
    resources
        .authenticationEntryPoint(authenticationEntryPoint);
  }

  /**
   * 不需要认证的
   *
   * @return java.lang.String[]
   * @author LiuYongTao
   * @date 2019/4/28 10:22
   */
  private String[] antMatchersPermitAll() {
    List<String> all = new ArrayList<>();
    // swagger start
    all.add("/swagger-ui.html");
    all.add("/swagger-resources/**");
    all.add("/images/**");
    all.add("/webjars/**");
    all.add("/v2/api-docs");
    all.add("/configuration/ui");
    all.add("/configuration/security");
    // swagger end
    String[] array = all.toArray(new String[all.size()]);
    return array;
  }
}
