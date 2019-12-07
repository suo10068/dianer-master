package com.dianer.study.annotation.config;

import com.dianer.study.annotation.common.CacheKeyGenerator;
import com.dianer.study.annotation.common.LockKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
}
