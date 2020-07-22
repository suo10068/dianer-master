package com.dianer;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
@MapperScan(basePackages = "com.dianer.mapper")
public class Application {





    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);

    }

}
