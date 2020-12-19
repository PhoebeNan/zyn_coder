package com.zyn;

import com.zyn.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringCloudTestApplicationTests {


    @Resource
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {

        String set = redisUtil.set("zyn", "2222", 1);
        String get = redisUtil.get("zyn",1);


        System.out.println(set);
        System.out.println(get);

    }

}
