//package com.zyn.tomcat;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.lang.reflect.Field;
//
///**
// * TomcatConfig
// * <p>
// * Tomcat优化：
// * 1、增加JVM内存：java -jar -Xms256m -Xmx256m abc.jar
// * 2、优化Tomcat配置参数
// * 3、使用APR
// *
// */
//@Configuration
//@Slf4j
//@EnableConfigurationProperties(ConfigProperties.class)
//public class TomcatConfig {
//
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory(ConfigProperties configProperties) {
//        ConfigProperties.Tomcat tomcat = configProperties.getTomcat();
//
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        tomcatServletWebServerFactory.setProtocol(tomcat.getProtocol());
//
//        tomcatServletWebServerFactory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            Field[] fields = tomcat.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                field.setAccessible(true);
//                try {
//                    connector.setAttribute(field.getName(), field.get(tomcat));
//                } catch (IllegalAccessException e) {
//                    log.error("Tomcat connector 配置异常", e);
//                    continue;
//                }
//            }
//        });
//
//        return tomcatServletWebServerFactory;
//    }
//}
