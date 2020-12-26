package com.zyn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@MapperScan(basePackages = {"com.zyn.dao","com.zyn.mbg.mapper"})//要扫描的dao包
public class SpringCloudTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTestApplication.class, args);
    }


    // 加载YML格式自定义配置文件
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();

        ClassPathResource redisClassPathResource = new ClassPathResource("redis/redis.yml");
        ClassPathResource threadClassPathResource = new ClassPathResource("thread/thread.yml");
        yaml.setResources(redisClassPathResource,threadClassPathResource);//File引入

        configurer.setProperties(yaml.getObject());
        return configurer;
    }

}
