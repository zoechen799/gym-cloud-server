package com.yiibo.gym.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: GatewayApplication
 * Description:
 * date: 2019/6/25 3:42 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@ComponentScan("com.yiibo.gym.gateway.config")
@ComponentScan("com.yiibo.gym.gateway.security.jwt")
public class GatewayApplication {


  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

}
