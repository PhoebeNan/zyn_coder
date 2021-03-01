package com.zyn.designer_pattern.strategy;


import org.springframework.stereotype.Component;

@Component
public class WechatStrategy implements Strategy{

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge;
    }

}
