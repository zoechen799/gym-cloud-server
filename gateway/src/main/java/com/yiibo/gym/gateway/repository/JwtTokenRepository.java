package com.yiibo.gym.gateway.repository;

import com.yiibo.gym.gateway.model.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassName: JwtTokenRepository
 * Description:
 * date: 2019/8/5 7:06 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken, String> {
  
}
