package com.bimforest.ems.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.bimforest.ems.autofill.MPMetaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 　* @description: mybatis-plus配置
 * 　* @author max.zhang
 * 　* @date 2019/6/27 14:58
 *
 */
@Configuration
public class MybatisPlusConfig {



    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 自动填充功能
     * @return
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MPMetaHandler());
        return globalConfig;
    }



}
