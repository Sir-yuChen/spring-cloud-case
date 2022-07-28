package com.zy.cloud.condig;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置了一个id为routr-name的路由规则
 */
@Configuration
public class GatewyConfig {
    /*我们现在配置的是YML进行配置的，还有一种配置方案就是通过硬编码的方式。就是代码中注入RouteLocator的Bean，是为了解决YML文件配置太多，文件太大的问题。那就开始撸起来吧！我们只要演示通过9527网关访问到外网的百度新闻网址。*/
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //uri 中 lb://服务名  代表从注册中心动态获取请求服务的地址
        routes.route("cloud-case-produce-hystrix", r -> r.path("/payment/hystrix/**").uri("lb://cloud-case-produce-hystrix")).build();
        routes.route("cloud-case-produce", r -> r.path("/payment/get/**").uri("lb://cloud-case-produce")).build();
        routes.route("cloud-case-consumer", r -> r.path("/consumer/**").uri("lb://cloud-case-consumer")).build();
        routes.route("cloud-case-consumer-openFeign", r -> r.path("/consumerFegin/**").uri("lb://cloud-case-consumer-openFeign")).build();
        return routes.build();
    }


    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }


}