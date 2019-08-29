package com.yiibo.gym.gateway.security.jwt;


import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: JwtProperties
 * Description:
 * date: 2019/8/27 5:33 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
  private String secretKey = "secret";

  //validity in milliseconds
  private long validityInMs = 3600000; // 1h
}
