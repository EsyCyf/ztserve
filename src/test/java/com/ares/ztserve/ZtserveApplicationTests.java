package com.ares.ztserve;

import com.ares.ztserve.mapper.ClientSatisfactionMapper;
import com.ares.ztserve.service.impl.ClientSatisfactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class ZtserveApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ClientSatisfactionServiceImpl clientSatisfactionService;
    @Test
    void redisTest() {
        int i = clientSatisfactionService.insertClientSatisfaction("chunmei_zeng@utacgroup.com",
                "1", 1, "1", "1"
        );
        System.out.println(i);
    }

}
