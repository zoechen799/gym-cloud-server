package com.yiibo.gym.registry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: RegisterApplication
 * Description:
 * date: 2019/6/18 12:25 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */

@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {

  public static void main(String[] args) {
    SpringApplication.run(RegistryApplication.class, args);
  }
}
