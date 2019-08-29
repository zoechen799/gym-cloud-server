package com.yiibo.gym.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: AuthenticationRequest
 * Description:
 * date: 2019/8/28 8:55 AM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest implements Serializable{
  private static final long serialVersionUID = -6986746375915710855L;
  private String username;
  private String password;
}
