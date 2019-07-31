package com.yiibo.gym.user.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * ClassName: Permission
 * Description:
 * date: 2019/6/25 4:58 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Data
@Entity
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 资源id
   */
  private String resourceId;

  /**
   * 资源名
   */
  private String resourceName;

  /**
   * 是否被遗弃
   */
  private boolean abandon = false;

  @OneToMany(mappedBy = "parentCity", cascade = CascadeType.ALL)
  private List<Privilege> privilegeList; // 元权限列表

}
