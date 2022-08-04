package com.zy.cloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
@RefreshScope
public class TestController {

    @Value("${service.info}")
    private String serviceInfo;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private String port;

    @GetMapping("/echo")
    public String echo(String name) {
        return name + "  你好，当前接口由:" + appName + ":" + port + "  [" + serviceInfo + "]  服务提供";
    }

}
