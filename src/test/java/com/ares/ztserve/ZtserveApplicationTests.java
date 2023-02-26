package com.ares.ztserve;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class ZtserveApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void redisTest() {
        stringRedisTemplate.opsForValue().set("name","卷心菜");
        String name = (String) stringRedisTemplate.opsForValue().get("name");
        System.out.println(name); //卷心菜
    }

}
