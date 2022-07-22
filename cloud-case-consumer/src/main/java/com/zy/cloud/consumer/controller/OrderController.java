package com.zy.cloud.consumer.controller;

import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.common.pojo.PaymentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    //调用生产者的 服务名
    public static final String PAYMENT_URL = "http://cloud-cas-produce";

    @Autowired
    private RestTemplate restTemplate;

    //创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public ApiReturn<PaymentPojo> create(PaymentPojo payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ApiReturn.class);
    }

    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public ApiReturn<PaymentPojo> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ApiReturn.class);
    }

    //服务发现
    @GetMapping("/payment/discovery")
    public Object discovery() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", Object.class);
    }

}
