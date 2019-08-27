package com.yiibo.gym.wechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName: WeChatApplication
 * Description:
 * date: 2019/8/13 2:30 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
public class WeChatApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeChatApplication.class, args);
  }

  @Value("${swagger.enabled}")
  private boolean swaggerShow;

  @Bean
  public Docket buildDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enable(swaggerShow)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.yiibo.gym.wechat.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("GYM 微信微服务")
        .description("微信小程序&公众号后台服务")
        .version("1.0")
        .build();
  }
}
