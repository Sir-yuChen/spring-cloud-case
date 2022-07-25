package com.zy.cloud.consumerHystrix.controller;


import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.consumerHystrix.service.PaymentHystrixService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
public class OrderHystrixController {

    private static Logger logger = LogManager.getLogger(OrderHystrixController.class);

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumerHystrix/payment/get/{id}")
    public ApiReturn getPaymentById(@PathVariable("id") Long id) {
        ApiReturn apiReturn = paymentHystrixService.queryById(id);
        return apiReturn;
    }
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumerHystrix/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    /**
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping("/consumerHystrix/payment/hystrix/timeout/{id}/{timeNumber}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id, @PathVariable("timeNumber") Integer timeNumber) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id, timeNumber);
        return result;

    }
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        return result;
    }


}
