package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient //eureka 客户端
@EnableDiscoveryClient //服务发现
public class CloudCaseProduceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseProduceApplication.class, args);
        System.out.println("springCloud Produce  start !!!");
    }
}
