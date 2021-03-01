package com.zyn.designer_pattern.strategy;

import com.zyn.utils.ApplicationContextUtils;
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


    private static Strategy eBankStrategy = ApplicationContextUtils.getBean(EBankStrategy.class);
    private static Strategy cardStrategy = ApplicationContextUtils.getBean(CardStrategy.class);
    private static Strategy wechatStrategy = ApplicationContextUtils.getBean(WechatStrategy.class);

    private static StrategyFactory strategyFactory = new StrategyFactory();

    private Strategy strategy;

    private StrategyFactory() {
    }

    private static Map<Integer, Strategy> map = new HashMap<>();

    static {
        map.put(RechargeTypeEnum.E_BANK.value(), eBankStrategy);
        map.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), cardStrategy);
        map.put(RechargeTypeEnum.MOBILE.value(), wechatStrategy);
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
//    @PostConstruct
//    public void init() {
//        StrategyFactory.eBankStrategy = eBankStrategy;
//        StrategyFactory.cardStrategy = cardStrategy;
//        StrategyFactory.wechatStrategy = wechatStrategy;
//    }


//    private static ICacheManager cacheManager;
//
//    @Autowired
//　　 public void setCacheManager(ICacheManager cacheManager) {
//        CacheExtensionsHelper.cacheManager = cacheManager;
//    }


}
