package com.bimforest.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author max.zhang
 * @title: SwaggerConfig
 * @projectName bimforest
 * @description: Swagger2配置类
 * @date 2019/9/119:09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 　* @description: 创建API应用
     * 　* @author max.zhang
     * 　* @date 2019/9/11 9:11
     * 　* @Copyright (C) 量树科技
     *
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 增加API相关信息
                .apiInfo(apiInfo())
                // 返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现
                .select()
                //扫描的包路径来定义指定要建立API的目录
                .apis(RequestHandlerSelectors.basePackage("com.bimforest.ems.modules"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
    　* @description: 创建该API的基本信息（这些基本信息会展现在文档页面中）,访问地址：http://项目实际地址/swagger-ui.html
    　* @author max.zhang
    　* @date 2019/9/11 9:12
    　* @Copyright (C) 量树科技
    　*/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("量树使用Swagger2构建RESTful APIs")
                /*.description("更多请关注http://www.baidu.com")
                .termsOfServiceUrl("http://www.baidu.com")*/
                .contact("max")
                .version("1.0")
                .build();
    }
}
