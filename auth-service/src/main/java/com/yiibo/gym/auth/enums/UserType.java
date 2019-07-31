package com.yiibo.gym.auth.enums;

/**
 * ClassName: UserType
 * Description: 登录用户的用户类型
 * date: 2019/7/3 2:19 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
public enum UserType {
  ADMIN(0),
  MANAGER(1),
  TEACHER(2),
  CUSTOMER(3);

  private int userType;

  UserType(int type){
    this.userType = type;
  }

  public int getUserType(){
    return this.userType;
  }
}
