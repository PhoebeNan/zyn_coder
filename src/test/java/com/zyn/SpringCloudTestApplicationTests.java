package com.zyn;

import com.zyn.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringCloudTestApplicationTests {


    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private TaskExecutor taskExecutor;


    @Test
    public void contextLoads2() {


        System.out.println("=====");

        String set = redisUtil.set("zyn", null);
        String set2 = redisUtil.set("zyn2", "");


    }


    @Test
    public void contextLoads23() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            taskExecutor.execute(() -> {
                System.out.print("*");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        ThreadPoolExecutor tpe = ((ThreadPoolTaskExecutor) taskExecutor).getThreadPoolExecutor();

        while (true) {
            System.out.println("=====================");

            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = tpe.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = tpe.getTaskCount();
            System.out.println("总线程数：" + taskCount);

            int largestPoolSize = tpe.getLargestPoolSize();
            System.out.println("曾在线程池中创建线程的最大数：" + largestPoolSize);

            Thread.sleep(3000);
        }

    }

}
