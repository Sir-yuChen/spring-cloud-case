package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard //监控注解
public class ColudCaseConsumerHystrixApplocation {
    public static void main(String[] args) {
        SpringApplication.run(ColudCaseConsumerHystrixApplocation.class, args);
        System.out.println("springCloud Consumer Hystrix start !!!");
    }
}
