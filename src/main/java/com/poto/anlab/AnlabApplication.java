package com.poto.anlab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.poto.anlab.mapper")
public class AnlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnlabApplication.class, args);
    }
}
