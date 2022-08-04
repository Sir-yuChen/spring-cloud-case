package com.zy.cloud.nacos.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
@RefreshScope
public class TestNacos {

    @Value("${appInfo}")
    private String info;

    @Value("${version}")
    private String version;


    @RequestMapping("/get")
    public String getNacos() {
        return "Nacos 配置中心获取到的信息:" + info + "版本号:" + version;
    }

}
