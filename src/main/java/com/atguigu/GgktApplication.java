package com.atguigu;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.mapper")
@MapperScan("ccom.atguigu.service")
public class GgktApplication {

    public static void main(String[] args) {
        SpringApplication.run(GgktApplication.class, args);
    }

}
