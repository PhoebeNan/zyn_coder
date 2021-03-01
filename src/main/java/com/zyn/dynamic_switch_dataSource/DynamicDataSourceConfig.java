//package com.zyn.dynamic_switch_dataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 配置多数据源
// * @Author zyn
// * @create 2021/1/28 17:50
// * @Description
// */
//@Configuration
//public class DynamicDataSourceConfig {
//
//    @Value("${dynamic.dataSource.primary}")
//
//    private String primaryDataSource;
//    @Value("${dynamic.dataSource.slave}")
//    private String slaveDataSource;
//
//    /**
//     * 创建 DataSource Bean
//     * */
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.one")
//    public DataSource oneDataSource(){
//        DataSource dataSource = DruidDataSourceBuilder.create().build();
//        return dataSource;
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.two")
//    public DataSource twoDataSource(){
//        DataSource dataSource = DruidDataSourceBuilder.create().build();
//        return dataSource;
//    }
//
//    /**
//     * 如果还有数据源,在这继续添加 DataSource Bean
//     * */
//    @Bean
//    @Primary
//    public MultipleDataSourceChoose dataSource(DataSource oneDataSource, DataSource twoDataSource) {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(primaryDataSource, oneDataSource);
//        targetDataSources.put(slaveDataSource, twoDataSource);
//        // 还有数据源,在targetDataSources中继续添加
//        System.out.println("DataSources:" + targetDataSources);
//        return new MultipleDataSourceChoose(oneDataSource, targetDataSources);
//    }
//}
