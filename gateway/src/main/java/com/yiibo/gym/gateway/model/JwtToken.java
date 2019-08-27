package com.yiibo.gym.gateway.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ClassName: JwtToken
 * Description:
 * date: 2019/8/5 5:07 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Data
@Entity
public class JwtToken {
  @Id
  private String token;

  public JwtToken(String token) {
    this.token = token;
  }

  public JwtToken() {
  }
}
