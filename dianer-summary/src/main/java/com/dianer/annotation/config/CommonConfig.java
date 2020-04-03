package com.dianer.annotation.config;

import com.dianer.annotation.common.CacheKeyGenerator;
import com.dianer.annotation.common.LockKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
}
