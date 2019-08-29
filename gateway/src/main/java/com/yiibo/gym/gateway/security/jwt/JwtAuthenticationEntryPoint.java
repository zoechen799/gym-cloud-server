package com.yiibo.gym.gateway.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import lombok.extern.slf4j.Slf4j;
/**
 * ClassName: JwtAuthenticationEntryPoint
 * Description:
 * date: 2019/8/27 5:35 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
                       AuthenticationException authException) throws IOException, ServletException {
    log.debug("Jwt authentication failed:" + authException);

    response.sendError(HttpServletResponse.SC_UNAUTHORIZED	, "Jwt authentication failed");

  }
}
