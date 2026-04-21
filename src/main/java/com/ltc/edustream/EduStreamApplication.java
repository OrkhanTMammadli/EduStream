package com.ltc.edustream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EduStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduStreamApplication.class, args);
    }

}
