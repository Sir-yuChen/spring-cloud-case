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
@EnableFeignClients//激活Feign的注解  需要加到主启动类上
public class CloudCaseConsumerOpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseConsumerOpenFeignApplication.class, args);
        System.out.println("springCloud Consumer OpenFegin start ！！！");
    }
}
