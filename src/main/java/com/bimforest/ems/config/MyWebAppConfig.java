package com.bimforest.ems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author max.zhang
 * @title: MyWebAppConfig
 * @projectName bimforest
 * @description: 文件上传路径配置
 * @date 2019/9/1813:27
 * @Copyright (C) 量树科技
 */
@Configuration
public class MyWebAppConfig implements WebMvcConfigurer {

    @Value("${web.upload-path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pi/**").addResourceLocations("file:" + uploadPath);
    }
}

