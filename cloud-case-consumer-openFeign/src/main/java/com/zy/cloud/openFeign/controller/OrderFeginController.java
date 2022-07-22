package com.zy.cloud.openFeign.controller;

import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.openFeign.service.PaymentFeginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
public class OrderFeginController {

    @Resource
    PaymentFeginService paymentFeginService;

    @GetMapping("/consumerFegin/payment/get/{id}")
    public ApiReturn getPaymentById(@PathVariable("id") Long id) {
        ApiReturn apiReturn = paymentFeginService.queryById(id);
        return apiReturn;
    }

}
