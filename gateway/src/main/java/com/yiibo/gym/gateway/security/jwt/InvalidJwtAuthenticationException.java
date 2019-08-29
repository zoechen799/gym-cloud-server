package com.yiibo.gym.gateway.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * ClassName: InvalidJwtAuthenticationException
 * Description:
 * date: 2019/8/27 5:35 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
public class InvalidJwtAuthenticationException extends AuthenticationException {
  /**
   *
   */
  private static final long serialVersionUID = -761503632186596342L;

  public InvalidJwtAuthenticationException(String e) {
    super(e);
  }
}
