package com.vt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vt.dao")
@SpringBootApplication
public class VtApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtApplication.class, args);
    }

}
