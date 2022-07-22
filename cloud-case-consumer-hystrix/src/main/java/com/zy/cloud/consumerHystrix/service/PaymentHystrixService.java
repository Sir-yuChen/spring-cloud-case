package com.zy.cloud.consumerHystrix.service;


import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.consumerHystrix.service.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ComponentScan
//使用Feign对某一个服务  fallback 降级处理类  fallbackFactory降级处理工程
@FeignClient(value = "CLOUD-CASE-PRODUCE-HYSTRIX", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/get/{id}")
    public ApiReturn queryById(@PathVariable("id") Long id);


    @GetMapping("/payment/hystrix/timeout/{id}/{timeNumber}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id, @PathVariable("timeNumber") Integer timeNumber);

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);
}
