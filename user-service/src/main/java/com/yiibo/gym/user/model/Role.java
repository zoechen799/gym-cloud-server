package com.yiibo.gym.user.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ClassName: Role
 * Description:
 * date: 2019/6/25 4:51 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private String nickname;

  private String description;

  private Boolean banned; // 是否为内置

  private String proposer; // 角色创建者

  private Long createdTime = System.currentTimeMillis(); // 创建时间

  /**
   * Spring Security 4.0以上版本角色都默认以'ROLE_'开头
   * @param name
   */
  public void setName(String name){
    if (name.indexOf("ROLE_") == -1) {
      this.name = "ROLE_" + name;
    } else {
      this.name = name;
    }
  }
}
