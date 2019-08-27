package com.yiibo.gym.gateway.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DocumentationConfig
 * Description:
 * date: 2019/7/30 1:37 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. yiibo.com All Rights Reserved.
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider{
  @Override
  public List<SwaggerResource> get() {
    List resources = new ArrayList<>();
    resources.add(swaggerResource("课程服务", "/course/v2/api-docs", "1.0"));
    resources.add(swaggerResource("微信服务", "/wechat/v2/api-docs", "1.0"));
    return resources;
  }

  private SwaggerResource swaggerResource(String name, String location, String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion(version);
    return swaggerResource;
  }
}
