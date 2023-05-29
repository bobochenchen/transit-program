package com.chenbo.testredis;

import io.lettuce.core.RedisClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class TestRedisApplicationTests {
//    @Resource
    RedisTemplate redisTemplate;

//    @Resource
    RedisClient redisClient;

    @Test
    void contextLoads() {
        System.out.println("c");
    }

}
