package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * ClassName: City
 * Description:
 * date: 2019/6/18 1:21 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private int code; // 上海 021

  @OneToMany(mappedBy = "parentCity", cascade = CascadeType.ALL)
  private List<District> districtList; // 城市下的区列表

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
