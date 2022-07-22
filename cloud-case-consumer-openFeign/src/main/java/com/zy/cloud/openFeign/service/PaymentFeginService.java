package com.zy.cloud.openFeign.service;


import com.zy.cloud.common.commonResult.ApiReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ComponentScan
@FeignClient(value = "CLOUD-CASE-PRODUCE")//使用Feign对某一个服务
public interface PaymentFeginService {

    @GetMapping("/payment/get/{id}")
    public ApiReturn queryById(@PathVariable("id") Long id);


}
