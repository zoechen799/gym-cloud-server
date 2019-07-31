package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: TeacherRepository
 * Description:  任课老师
 * date: 2019/6/18 1:01 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private String mobilePhone;

  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="location_id")
  private Location location; // 上课场地

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
