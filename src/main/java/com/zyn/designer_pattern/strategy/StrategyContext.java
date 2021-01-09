package com.zyn.designer_pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @Author zyn
 * @create 2021/1/9 16:56
 * @Description
 */
@Component
public class StrategyContext {

    private Strategy strategy;

    public Double calRecharge(Double charge ,Integer type ){

        strategy= StrategyFactory.getInstance().creator(type);

        return strategy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
    }
}
