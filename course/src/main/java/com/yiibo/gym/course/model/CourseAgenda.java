package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * ClassName: CourseAgenda
 * Description: 课程安排（排课）
 * date: 2019/6/18 1:39 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class CourseAgenda {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, optional = false) // courseId不能为空
  @JoinColumn(name="course_id")
  private Course course; // 对应的课程唯一标识 多对一

  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="teacher_id")
  private Teacher teacher; // 实际任课教师

  private int no; //第几节课

  private Date courseDate; //安排日期

  private Timestamp startTime; //开始时间

  private Timestamp endTime; //结束时间

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
