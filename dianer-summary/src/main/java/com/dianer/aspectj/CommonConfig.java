package com.dianer.aspectj;

import com.dianer.aspectj.common.CacheKeyGenerator;
import com.dianer.aspectj.common.LockKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class CommonConfig {

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
}
