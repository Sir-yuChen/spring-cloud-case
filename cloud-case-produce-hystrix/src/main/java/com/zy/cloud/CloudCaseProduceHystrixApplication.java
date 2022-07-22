package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient //eureka 客户端
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //降级处理 开启
public class CloudCaseProduceHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseProduceHystrixApplication.class, args);
        System.out.println("springCloud Produce  Hystrix start !!!");
    }
}
