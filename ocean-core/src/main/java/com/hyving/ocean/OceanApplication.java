package com.hyving.ocean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@SpringBootApplication
@MapperScan("com.hyving.ocean.dao.mapper")
public class OceanApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanApplication.class,args);
    }
}
