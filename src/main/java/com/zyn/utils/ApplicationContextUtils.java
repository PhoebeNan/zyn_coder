package com.zyn.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author zyn
 * @create 2021/2/23 11:14
 * @Description
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        ApplicationContextUtils.context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }

    /**
     * 通过名称获取bean
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return getContext().getBean(name);
    }

    /**
     * 通过Class获取bean
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getContext().getBean(clazz);
    }

    /**
     * 通过name,Class获取bean
     * @param name
     * @param clazz
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getContext().getBean(name,clazz);
    }
}
