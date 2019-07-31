package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * ClassName: Customer
 * Description:
 * date: 2019/6/18 1:35 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private String wxOpenId; // 微信公众号OpenId

  private String wxAppOpenId; // 微信小程序OpenId

  private String mobilePhone; // 手机号

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
