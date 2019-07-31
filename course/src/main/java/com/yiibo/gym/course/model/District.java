package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: District
 * Description:
 * date: 2019/6/18 1:22 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class District {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, optional = false)
  @JoinColumn(name="city_id")
  private City parentCity; // 所在城市

  private String name;

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
