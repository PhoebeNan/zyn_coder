package com.zyn.designer_pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyn
 * @create 2021/1/9 16:56
 * @Description
 */
public class StrategyFactory {

    @Resource(name = "eBankStrategy")
    private EBankStrategy eBankStrategy;
    private static EBankStrategy eBankStrategy2;
    @Resource(name = "cardStrategy")
    private CardStrategy cardStrategy;
    private static CardStrategy cardStrategy2;
    @Resource(name = "wechatStrategy")
    private WechatStrategy wechatStrategy;
    private static WechatStrategy wechatStrategy2;

    private static StrategyFactory strategyFactory = new StrategyFactory();

    private Strategy strategy;

    private StrategyFactory() {
    }

    private static Map<Integer, Strategy> map = new HashMap<>();

    static {
        map.put(RechargeTypeEnum.E_BANK.value(), eBankStrategy2);
        map.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), cardStrategy2);
        map.put(RechargeTypeEnum.MOBILE.value(), wechatStrategy2);
    }

    public Strategy creator(Integer type) {
        return map.get(type);
    }

    public static StrategyFactory getInstance() {
        return strategyFactory;
    }

    //类上面要添加注解@Component, 告诉spring这个类需要扫描
    //set方法上添加@Autowired注解, 告诉spring自动注入
    //set方法不要添加static关键字,否则自动注入失败
    //方式二
    @PostConstruct
    public void init() {
        StrategyFactory.eBankStrategy2 = eBankStrategy;
        StrategyFactory.cardStrategy2 = cardStrategy;
        StrategyFactory.wechatStrategy2 = wechatStrategy;
    }


//    private static ICacheManager cacheManager;
//
//    @Autowired
//　　 public void setCacheManager(ICacheManager cacheManager) {
//        CacheExtensionsHelper.cacheManager = cacheManager;
//    }


}
