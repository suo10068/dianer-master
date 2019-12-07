package com.dianer;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Log4j2
@MapperScan(basePackages = "com.dianer.mapper")
@SpringBootApplication
@EnableEurekaClient
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        log.info("=== Dianer Server Application Started! ===");
    }


}
