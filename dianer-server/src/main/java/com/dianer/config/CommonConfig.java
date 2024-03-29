package com.dianer.config;

import com.dianer.aspectj.annotation.CacheKeyGenerator;
import com.dianer.aspectj.annotation.LockKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
}
