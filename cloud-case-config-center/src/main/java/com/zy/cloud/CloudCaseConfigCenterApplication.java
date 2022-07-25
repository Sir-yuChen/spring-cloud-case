package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer // 配置中心注解
public class CloudCaseConfigCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseConfigCenterApplication.class, args);
        System.out.println("springCloud Cofig Center start !!! ");
    }
}
