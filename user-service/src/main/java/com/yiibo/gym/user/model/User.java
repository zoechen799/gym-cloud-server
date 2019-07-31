package com.yiibo.gym.user.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ClassName: User
 * Description:
 * date: 2019/6/25 4:46 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String username;

  private String realName;

  private String password;

  private String type;

  private String wxOpenid;

  private String wxappOpenid;

  private String mobilePhone;

  private boolean enabled;

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
