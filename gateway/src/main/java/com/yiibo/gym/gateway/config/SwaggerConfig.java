package com.yiibo.gym.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;

/**
 * ClassName: SwaggerConfig
 * Description:
 * date: 2019/7/31 9:50 AM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${swagger.enabled}")
  private boolean swaggerEnabled;

  @Bean
  public Docket buildDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enable(swaggerEnabled)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Zuul 网关聚集服务")
        .description("Swagger API Doc")
        .version("1.0")
        .build();
  }

  @Bean
  UiConfiguration uiConfig() {
    return new UiConfiguration(null, "list", "alpha", "schema",
        UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
  }

}
