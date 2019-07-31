package com.yiibo.gym.auth.repository;

import com.yiibo.gym.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ClassName: UserRepository
 * Description:
 * date: 2019/7/3 2:26 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
