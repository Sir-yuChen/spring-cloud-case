package com.zy.cloud.consumer.config.myRule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 进行自定义 负载均衡的算法
 **/
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        //自定义负载均衡策略
        MyCustomRule rule = new MyCustomRule();
//        RoundRobinRule rule = new RoundRobinRule();
        return rule;
    }

}
