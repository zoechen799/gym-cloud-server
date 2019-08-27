package com.yiibo.gym.gateway.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * ClassName: User
 * Description:
 * date: 2019/8/5 5:21 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotEmpty(message = "*please provide an username")
  private String username;

  private String password;

  private String name;

  private Integer active=1;

  private boolean isLoacked=false;

  private boolean isExpired=false;

  private boolean isEnabled=true;

  @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
  private List<Role> role;

}
