package com.yiibo.gym.course.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * ClassName: CourseAgenda
 * Description: 上课打卡记录
 * date: 2019/6/18 1:39 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class CourseLog {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name="course_agenda_id")
  private CourseAgenda courseAgenda; //对应的排课记录

  private Timestamp startTime; //实际开始时间

  private Timestamp endTime; //实际结束时间

  private String remark; //老师课堂评论

  private int rating; //老师打分

  private Long createdTime = System.currentTimeMillis(); // 创建时间
}
