package com.zy.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudCaseConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCaseConfigClientApplication.class, args);
        System.out.println("springCloud Cofig Client start !!! ");
    }
    /**
     *
        远程配置文件仓库：
         cloud-case-config-client-dev.yml

         http请求地址和资源文件映射如下:
         /{application}/{profile}[/{label}]
         /{application}-{profile}.yml
         /{label}/{application}-{profile}.yml
         /{application}-{profile}.properties
         /{label}/{application}-{profile}.properties
     */
    /*
    * springcloud bus 消息总线  远程修改最新配置只需发送一次post请求，既可以使用所用的client获取到最新的配置信息
    *
    * curl -X POST "http://localhost:8021/actuator/bus-refresh" //bus-refresh 在配置中心向保留的请求路径
    *
    * 如果只需要更新其中一个clinet，需要想配置中心发送post请求指定更新的client
    * curl -X POST "http://{配置中心的地址}/actuator/bus-refresh/{destination}" //destination具体为微服务+端口号
        curl -X POST "http://localhost:8020/actuator/bus-refresh/cloud-case-config-client:8022"
     *
    * */


  /*  @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        //忽略暂时未取到的value远程配置文件值
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }*/


}