package com.chenbo.testredis.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class Single {
//    @Resource
//    StringRedisTemplate redisTemplate;
//    RedisTemplate redisTemplate;
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    /**
//     * 单机版redis锁，避免并发问题
//     * @return
//     */
//    @GetMapping("/redistest")
//    public String decrStock(){
//        int inventory=1001;
//        int NUM=1000;
//
//
//        Boolean fyx = redisTemplate.opsForValue().setIfAbsent("product::" + Thread.currentThread().getName(), "fyx", 30, TimeUnit.SECONDS);
//        System.out.println(fyx);
//        System.out.println(redisTemplate.opsForValue().setIfAbsent("b","2"));
//        ConcurrentHashMap<Object, Object> m = new ConcurrentHashMap<>();
//        m.put("1453234","c1");
//        m.put("532425","c2");
//        redisTemplate.opsForHash().putAll("c", m);
//
//        CopyOnWriteArraySet<Object> s = new CopyOnWriteArraySet<>();
//        s.add("hi set!");
//        s.add("hi hello");
//        s.add("hi set!");
//        redisTemplate.opsForSet().add("s", String.valueOf(s));
//        redisTemplate.opsForSet().add("s", s+"hi");
//
//
//        Set<String> stringSet = redisTemplate.opsForSet().members("s");
//        stringSet.forEach(System.out::println);
//
//        stringSet.stream()
//                .forEach(o->{
//                    System.out.println(o+"   stream!");
//                });
//
//        List<String> list = stringSet.stream()
//                .collect(Collectors.toList());
//        list.forEach(o->{
//            redisTemplate.opsForList().leftPush("l",o+"list");
//        });
//        System.out.println(redisTemplate.opsForList().range("l",0,-1));
//        System.out.println(redisTemplate.opsForList().rightPop("l",2));
//
//        Map<Object, Object> map = new ConcurrentHashMap<>();
//        map.put("姓名","张三");
//        map.put("性别","男");
//        redisTemplate.opsForHash().putAll("d",map);
//
//        Map<Object, Object> entries = redisTemplate.opsForHash().entries("d");
//        System.out.println(entries.get("性别"));
//        System.out.println(entries);
//        try {
//            if (fyx){
//                for (int i = 0; i <= NUM; i++) {
//                    inventory--;
//                    System.out.println("库存剩余："+inventory);
//                }
//                return "库存不足";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            redisTemplate.delete("product::"+Thread.currentThread().getName());
//        }

//        return "操作完成！";
//    }

//    @GetMapping("/redistest1")
//    public String RedisTest1(){
//
//        int inventory=1001;
//        int NUM=1000;
//        synchronized (this){
//            RLock lock = redissonClient.getLock("prodoct::" + Thread.currentThread().getName());
//            try {
//                for (int i = 0; i <= NUM; i++) {
//                    lock.lock();
//                    inventory--;
//                    lock.unlock();
//                    System.out.println("库存剩余："+inventory);
//                }
//                return "扣减完成！剩余："+inventory;
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//            }
//        }
//
//        return "操作完成！";
//    }
    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
