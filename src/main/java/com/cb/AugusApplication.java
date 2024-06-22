package com.cb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@SpringBootApplication()
@MapperScan("com.cb.mapper")

public class AugusApplication {

    public static void main(String[] args) {
        SpringApplication.run(AugusApplication.class, args);
    }

}
