package com.yiibo.gym.user.model;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: Privilege
 * Description:
 * date: 2019/6/25 6:08 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Privilege {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String key;

  private String name;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, optional = false) // courseId不能为空
  @JoinColumn(name="course_id")
  private Permission permission; // 对应的课程唯一标识 多对一

}
