package com.yiibo.gym.course.model;
import javax.persistence.*;

import lombok.Data;
/**
 * ClassName: CourseContent
 * Description: 每节课的课程内容，目标表
 * date: 2019/6/18 12:57 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class CourseContent {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, optional = false) // courseId不能为空
  @JoinColumn(name="course_id")
  private Course course; // 对应的课程唯一标识 多对一

  private int no; // 课程节次

  private int stage; //课程所在阶段

  private String description; // 课程描述

  private String goal; // 课程目标

  /**
   * 创建时间
   */
  private Long createdTime = System.currentTimeMillis();
}
