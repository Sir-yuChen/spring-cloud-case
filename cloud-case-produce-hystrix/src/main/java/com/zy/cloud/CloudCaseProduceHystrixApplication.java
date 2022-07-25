package com.zy.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


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
    /*
    *  服务熔断:服务端~    某个服务超时或者异常，引起熔断~  保险丝~

       服务降级: 客户端~ 从整体网站请求负载考虑~ ，当某个服务熔断或者关闭之后，服务将不再调用
         此时客户端，我们可以准备一个fallbackFactory，返回一个默认的值(缺省值) ， 整体的服务水平下降了~但是 好歹能用 ， 比直接挂掉强~
    */

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无观，springCloud 升级之后的坑
     * ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
     * 只要在自己的项目中配置上下面的servlet即可
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }


}
