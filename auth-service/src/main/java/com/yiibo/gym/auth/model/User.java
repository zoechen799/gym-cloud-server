package com.yiibo.gym.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yiibo.gym.auth.enums.UserType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

/**
 * ClassName: User
 * Description:
 * date: 2019/7/3 2:12 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Data
@Entity
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 创建时间
   */
  private Long createdTime = System.currentTimeMillis();

  /**
   * 用户登录名
   */
  private String username;

  /**
   * 用户登录密码，用户的密码不应该暴露给客户端
   */
  @JsonIgnore
  private String password;

  /**
   * 用户真实姓名
   */
  private String realName;

  /**
   * 微信公众号OpenId
   */
  private String wxOpenId;

  /**
   * 微信小程序OpenId
   */
  private String wxAppOpenId;

  /**
   * 用户类型
   */
  private UserType userType;

  /**
   * 对应类型的id Teacher.id Customer.id
   */
  private long typedObjectId;

  /**
   * 是否启用
   */
  private boolean enable;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return this.enable;
  }
}
