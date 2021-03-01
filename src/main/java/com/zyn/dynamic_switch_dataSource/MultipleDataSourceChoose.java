//package com.zyn.dynamic_switch_dataSource;
//
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
///**
// * 通过自定义注解动态切换多数据源
// * @Author zyn
// * @create 2021/1/28 17:12
// * @Description
// */
//public class MultipleDataSourceChoose extends AbstractRoutingDataSource {
//
//
//    /**
//     * 配置DataSource, defaultTargetDataSource为主数据库
//     */
//    public MultipleDataSourceChoose(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
//        super.setDefaultTargetDataSource(defaultTargetDataSource);
//        super.setTargetDataSources(targetDataSources);
//        super.afterPropertiesSet();
//    }
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//
//        return HandleChooseDataSource.getDataSource();
//    }
//}
