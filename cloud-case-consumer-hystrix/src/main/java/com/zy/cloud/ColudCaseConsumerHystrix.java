package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker //降级处理 开启
public class ColudCaseConsumerHystrix {
    public static void main(String[] args) {
        SpringApplication.run(ColudCaseConsumerHystrix.class, args);
        System.out.println("springCloud Consumer Hystrix start !!!");
    }
}
