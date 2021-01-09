package com.zyn.designer_pattern.strategy;


import org.springframework.stereotype.Component;

@Component("cardStrategy")
public class CardStrategy implements Strategy{

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge*0.95;
    }

}
