package com.zy.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudCaseConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseConfigClientApplication.class, args);
        System.out.println("springCloud Cofig Client start !!! ");
    }
}