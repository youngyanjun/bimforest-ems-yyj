package com.bimforest.ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bimforest.ems.modules.*.mapper")
public class BimforestEMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(BimforestEMSApplication.class, args);
    }

}
