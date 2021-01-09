package com.zyn.designer_pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author zyn
 * @create 2021/1/9 17:21
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestClient {

    @Resource
    private StrategyContext strategyContext;

    @Test
    public void test(){
        Double aDouble = strategyContext.calRecharge(10.00d, 1);
        Double aDouble1 = strategyContext.calRecharge(10.00d, 2);
        Double aDouble2 = strategyContext.calRecharge(10.00d, 3);
        System.out.println("");
    }
}
