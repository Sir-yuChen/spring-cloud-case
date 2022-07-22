package com.zy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class CloudCaseEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseEurekaServerApplication.class, args);
        System.out.println("springCloud Eureka start !!!");
    }
}
