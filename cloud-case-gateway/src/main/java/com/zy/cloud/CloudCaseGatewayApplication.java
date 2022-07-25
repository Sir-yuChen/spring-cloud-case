package com.zy.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class CloudCaseGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseGatewayApplication.class, args);
        System.out.println("SpringCloud Gateway start !!! ");
    }
}
