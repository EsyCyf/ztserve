package com.ares.ztserve.config;


import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ESy
 * @date 2023/2/23 023 13:58
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String CHITIC_BANK_API_PACKAGE = "com.ares.ztserve.controller";

    @Bean
    public Docket pdaApi() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("token")
                .description("认证token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SpringBoot1.0 API")
                .apiInfo(pdaApiInfo())
                .globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CHITIC_BANK_API_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo pdaApiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot1.0接口")
                .description("SpringBoot1.0 API接口文档")
                .version("v1.0")
                .build();
    }

}
