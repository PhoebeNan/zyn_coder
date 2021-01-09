package com.zyn;

import com.zyn.aop.ApplicationContextUtil;
import com.zyn.aop.TargetClass;
import com.zyn.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringCloudTestApplicationTests {


    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private TaskExecutor taskExecutor;


    @Test
    public void testAOP() {

        //2、从IOC容器中获取bean的实例
        TargetClass targetClass = (TargetClass) ApplicationContextUtil.getBean(TargetClass.class);

        //3、使用bean
        String result = targetClass.joint("spring","aop");
        String result2 = targetClass.joint2("spring","aop");

    }




    @Test
    public void contextLoads() {


        Set<String> strings = new HashSet<>();
        strings.add("2");
        strings.add("23");
        strings.add("23");

        System.out.println(strings);
        System.out.println(String.valueOf(strings));

        Integer[] x = {1};

        for (int i = 0; i < 100; i++) {

            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {

                    //方式二
                    test(x);

                    //方式一
//                    synchronized (SpringCloudTestApplicationTests.class) {
//                        x[0]++;
//                        System.out.println(Thread.currentThread().getName() + "----------------------->" + x[0]);
//                    }
                }

            });
        }

        System.out.println("=====");
    }

    private  void test(Integer[] x) {
        x[0]++;
        System.out.println(Thread.currentThread().getName() + "----------------------->" + x[0]);
    }


    @Test
    public void contextLoads2() {


        HashMap<Object, Object> map = new HashMap<>();
        Object o = map.get("123");
        System.out.println(o);

        System.out.println("=====");


        redisUtil.del("zyn");


        String set = redisUtil.set("zyn", null);
        String set2 = redisUtil.set("zyn2", "");

        System.out.println(redisUtil.get("zyn"));
        System.out.println(redisUtil.get("zyn2"));

        redisUtil.hset("zyn","b","123");
        System.out.println(redisUtil.hget("zyn","b"));






        System.out.println(redisUtil.get("zyn"));
        System.out.println(redisUtil.hget("zyn","b"));

//        redisUtil.hset("zyn","a","123");
//        redisUtil.del("zyn");
//        System.out.println(redisUtil.hget("zyn","b"));
//
//
//
//
//
//
//
//        redisUtil.hset("zyn","b","123");
//        System.out.println(redisUtil.hget("zyn","a"));
//        System.out.println(redisUtil.hget("zyn","b"));
//
//        String get = redisUtil.get("zyn");
//
//        System.out.println(redisUtil.get("zyn"));
////        HashMap<String, String> map = new HashMap<>();
////
////        map.put("a","123");
////        map.put("b","1234");
//
//        System.out.println(redisUtil.hget("zyn","a"));
//        System.out.println(redisUtil.hget("zyn","b"));



    }

}
