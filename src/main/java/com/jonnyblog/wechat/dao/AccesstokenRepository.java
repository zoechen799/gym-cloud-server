package com.jonnyblog.wechat.dao;

import com.jonnyblog.wechat.model.Accesstoken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: AccesstokenRepository
 * Description:
 * date: 2019/6/10 11:12 AM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
public interface AccesstokenRepository extends JpaRepository<Accesstoken, String> {

  Accesstoken findByAppidAndSecret(String appid, String secret);
}