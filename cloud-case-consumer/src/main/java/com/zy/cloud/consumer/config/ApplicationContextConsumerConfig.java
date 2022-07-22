package com.zy.cloud.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 */
@Configuration
public class ApplicationContextConsumerConfig {
    @Bean
    @LoadBalanced //RestTemplate 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     *  IRule的七大负载算法:
     *      com.netfix.loadbalancer.RoundRobinRule  轮询
     *      com.netfix.loadbalancer.RandomRule      随机
     *      com.netfix.loadbalancer.RetryRule       轮询 超时重试
     *      WeightedResponseTimeRule    对RoundRobinRule的扩展 ，响应速度快的实例选择权重越大，越容易被选择
     *      BestAvailableRule   先过滤掉故障，跳闸的服务，然后选择一个当前并发最小的服务执行
     *      AvailbilityFilteringRule    过滤跳闸服务  选择并发较小得服务实例
     *      zoneAvoidanceRule   默认规则，符合判断server所在区域的性能和server的可用性选择服务器
     *
     *
     */


}
