package com.jonnyblog.wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger2.show}")
    private boolean swaggerShow;
	
    @Bean
    public Docket addUserDocket() {
        ApiInfo apiInfo = new ApiInfo("课程管理系统API", "WEB API文档", "V0.0.1", "", new Contact("","",""), "", "");
        return new Docket(DocumentationType.SWAGGER_2)
        		.enable(swaggerShow)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jonnyblog.wechat.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}