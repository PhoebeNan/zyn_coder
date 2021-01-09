package com.zyn.aop;

import com.zyn.aop.annotation.CacheRemoveAspect;
import org.springframework.stereotype.Component;

/**
 * 被代理对象
 */
@Component
public class TargetClass {
    /**
     * 拼接两个字符串
     */
//    @CacheRemoveAspect
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }

    @CacheRemoveAspect
    public String joint2(String str1, String str2) {
        return str1 + "-" + str2;
    }
}
