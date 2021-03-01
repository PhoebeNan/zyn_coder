//package com.zyn.dynamic_switch_dataSource;
//
///**
// * 根据当前线程选择具体的数据源
// * @Author zyn
// * @create 2021/1/28 17:14
// * @Description
// */
//public class HandleChooseDataSource {
//
//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
//
//    /**
//     * 提供给AOP去设置当前的线程的数据源的信息
//     * @param key
//     */
//    public static void putDataSource(String key){
//        threadLocal.set(key);
//    }
//
//    /**
//     * 提供给AbstractRoutingDataSource的实现类，通过key选择数据源
//     * @return
//     */
//    public static String getDataSource(){
//        return threadLocal.get();
//    }
//
//    /**
//     * 使用默认的数据源
//     */
//    public static void clear(){
//        threadLocal.remove();
//    }
//
//}
