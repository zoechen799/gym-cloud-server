package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: Location
 * Description: 上课场地
 * date: 2019/6/18 1:18 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="district_id")
  private District district; // 所在区

  private String address; // 上课详细地址

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
