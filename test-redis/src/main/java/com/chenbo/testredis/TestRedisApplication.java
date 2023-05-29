package com.chenbo.testredis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.ssssssss.magicapi.core.annotation.MagicModule;

@SpringBootApplication
public class TestRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRedisApplication.class, args);
    }

//    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
