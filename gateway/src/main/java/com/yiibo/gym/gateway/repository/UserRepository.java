package com.yiibo.gym.gateway.repository;

import com.yiibo.gym.gateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserRepository
 * Description:
 * date: 2019/8/5 7:08 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
