package com.zy.cloud.openFeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {

    /**
     *Openfeign提供了日志打印功能
     *  比如我们消费者服务调用生产者的服务的时候在接口调用的时候，我们可能需要更详细的信息，如信息头、状态码、时间、接口等等。
     *  就可以使用Openfeign日志打印功能，我们可以通过配置来调整日志级别，从而了解Feign中Http请求的细节。也就是对Feign接口的调用情况进行监控和输出。
     *
     *  Logger有四种类型：
     *
     * NONE：默认的，不显示任何日志。
     *
     * BASIC：仅记录请求方法、URL、响应状态及执行时间。
     *
     * HEADERS：除了BASIC中定义的信息之外，还有请求和响应的有信息。
     *
     * FULL：除了BASIC中定义的信息之外，还有请求和响应的正文及元数据。
     *
     * 通过注册Bean来设置日志记录级别！
     *
     */
    /**
     * feignClient配置日志级别
     *  在yml文件中需要开启日志的Feign客户端，要写PaymentService业务类的全限定类名
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }





}
