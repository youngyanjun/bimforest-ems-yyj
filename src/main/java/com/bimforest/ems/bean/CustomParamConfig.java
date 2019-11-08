package com.bimforest.ems.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author youngyanjun
 * @title: ${}
 * @date 2019-11-08 16:04
 */

@Component
public class CustomParamConfig {



 private static String salt;

    public static String getSalt() {
        return salt;
    }

    @Autowired(required = false)
    @Value("${custom.salt}")
    public  void setSalt(String salt) {
        CustomParamConfig.salt = salt;
    }

}
