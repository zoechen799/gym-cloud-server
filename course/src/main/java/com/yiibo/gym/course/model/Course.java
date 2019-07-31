package com.yiibo.gym.course.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

/**
 * ClassName: Course
 * Description: 课程，比如 1. 单人普通会员班（15课时） 2. 双人金卡会员班（30课时）
 * date: 2019/6/18 12:49 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="teacher_id")
  private Teacher teacher; // 开课老师

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<CourseContent> courseContentList; // 课程内容列表

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<CourseAgenda> courseAgendaList; // 排课列表

  private String name; // 课程名字

  private String description; //课程描述

  private float totalPrice; // 课程总价格(单人）

  private float  unitePrice; //课程单价 如单人普通会员班（15课时），每次课的价格为 3666/15 = 244.4

  private int classSize; //课程上课人数

  private float periods; // 课时量（次为单位）

  private float hoursEachTime; // 每次课上课时长

  private boolean isActive; //是否上架

  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="member_ship_id")
  private MemberShip memberShip; // 课程对应的会员等级

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
