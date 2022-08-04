package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class ColudCaseConsumerNacosApplocation {

    public static void main(String[] args) {
        SpringApplication.run(ColudCaseConsumerNacosApplocation.class, args);
        System.out.println("springCloud Consumer Nacos start !!!");
    }
    /**
     *  注意版本对应：
     *  spring cloud Alibaba    springBoot
     *  1.5.x----> spring Boot 1.5.x
     *  2.0.x----> spring Boot 2.0.x
     *  2.1.x----> spring Boot 2.1.x
     *  2.2.x----> spring Boot 2.2.x
     *
     *  ncaos 配置文件 dataId命令 默认: 应用名-环境.配置文件格式
     *
     */
}
