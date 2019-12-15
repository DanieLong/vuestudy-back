package com.lk.test.vuestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.lk.test.vuestudy.dao")
@SpringBootApplication
public class VuestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuestudyApplication.class, args);
    }

}
