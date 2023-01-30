package com.ivelite.fokchongdev.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfig {

    @Bean
    public Cache<String, Object> CaffeineCacheConfig(){
        return Caffeine.newBuilder().expireAfterWrite(15,TimeUnit.SECONDS).build();
    }

}
