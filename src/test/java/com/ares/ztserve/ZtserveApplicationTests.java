package com.ares.ztserve;

import com.ares.ztserve.mapper.ClientSatisfactionMapper;
import com.ares.ztserve.service.impl.ClientSatisfactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

@SpringBootTest
class ZtserveApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ClientSatisfactionServiceImpl clientSatisfactionService;
    @Test
    void redisTest() {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        String token2 = UUID.randomUUID().toString().replaceAll("-", "");
        String username = "APLUS";
        stringRedisTemplate.opsForValue().set(username,token);
        stringRedisTemplate.opsForValue().set(token,username);
//        stringRedisTemplate.opsForSet().add(username,token2);
        String s = stringRedisTemplate.opsForValue().get(username);
        System.out.println(s);


    }

}
