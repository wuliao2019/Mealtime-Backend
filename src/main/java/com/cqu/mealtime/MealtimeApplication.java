package com.cqu.mealtime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqu.mealtime.dao")
public class MealtimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MealtimeApplication.class, args);
    }
}
