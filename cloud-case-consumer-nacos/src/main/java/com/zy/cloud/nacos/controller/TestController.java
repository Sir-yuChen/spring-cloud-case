package com.zy.cloud.nacos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("nacos")
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient; //负载均衡

    @GetMapping("/hello")
    public String hello(String name) {
        // <1> 获得服务 `cloud-case-produce-nacos` 的一个实例
        ServiceInstance instance;
        if (true) {
            // 获取服务 `cloud-case-produce-nacos` 对应的实例列表
            List<ServiceInstance> instances = discoveryClient.getInstances("cloud-case-produce-nacos");
            // 选择第一个
            instance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            instance = loadBalancerClient.choose("cloud-case-produce-nacos");
        }
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/nacos/echo?name=" + name;
        String response = restTemplate.getForObject(targetUrl, String.class);
        // 返回结果
        return "consumer:" + response;
    }

}
