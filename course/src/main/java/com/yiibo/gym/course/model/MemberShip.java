package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ClassName: MemberShip
 * Description:
 * date: 2019/6/24 5:45 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class MemberShip {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private int levelNumber; // 会员等级 0:非会员 1:普通会员 2:金卡会员 3:黑金会员

  private String description;

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
