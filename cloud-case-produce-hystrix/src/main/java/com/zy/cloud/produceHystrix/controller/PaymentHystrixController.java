package com.zy.cloud.produceHystrix.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zy.cloud.common.commonCode.ApiReturnCode;
import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.common.pojo.PaymentPojo;
import com.zy.cloud.produceHystrix.service.PaymentHystrixService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * PaymentController
 *
 * @author zy
 * @since 2022-07-21
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentHystrixController {

    private static Logger logger = LogManager.getLogger(PaymentHystrixController.class);

    @Resource
    private PaymentHystrixService paymentPojoService;

    @Resource
    private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;

    @Value("${eureka.instance.instance-id}")
    private String serviceInstance;
    @Value("${spring.application.name}")
    private String serviceName;


    @PostMapping("/payment/create")
    public ApiReturn create(@RequestBody PaymentPojo dept) {
        logger.info("服务{}被执行！！", serviceInstance);
        int i = paymentPojoService.create(dept);
        if (i > 0) {
            return new ApiReturn(ApiReturnCode.SUCCESSFUL);
        } else {
            return new ApiReturn(ApiReturnCode.HTTP_ERROR);
        }
    }

    @GetMapping("/payment/get/{id}")
    public ApiReturn queryById(@PathVariable("id") Long id) {
        logger.info("服务{}被执行！！", serviceInstance);
        PaymentPojo payment = paymentPojoService.queryById(id);
        if (payment != null) {
            ApiReturn apiReturn = new ApiReturn();
            apiReturn.setData(payment);
            apiReturn.setApiReturnCode(ApiReturnCode.SUCCESSFUL);
            return apiReturn;
        } else {
            return new ApiReturn(ApiReturnCode.HTTP_ERROR);
        }
    }

    //服务发现
    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            logger.info("============> 注册到eureka注册中心的服务:{}", service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        instances.forEach(item -> {
            logger.info("服务名:{},实例名:{},host:{},port:{},当前服务下共{}实例",
                    serviceName, item.getServiceId(), item.getHost(), item.getPort(), instances.size());
        });
        return this.discoveryClient;
    }

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentPojoService.paymentInfo_OK(id);
        logger.info("*******************result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}/{timeNumber}")
//    @HystrixCommand//默认的fallback注解
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id, @PathVariable("timeNumber") Integer timeNumber) {
        String result = paymentPojoService.paymentInfo_TimeOut(id, timeNumber);
        logger.info("*********************result:" + result);
        return result;

    }

    @GetMapping("/payment/hystrix/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentPojoService.paymentCircuitBreaker(id);
        return result;

    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }


}

