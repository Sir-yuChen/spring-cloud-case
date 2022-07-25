package com.zy.cloud.produceHystrix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zy.cloud.common.pojo.PaymentPojo;

/**
*  Service接口 : 
*  @author zy
*  @since 2022-07-21
*/
public interface PaymentHystrixService extends IService<PaymentPojo> {

    int create(PaymentPojo dept);

    PaymentPojo queryById(Long id);

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id, Integer timeNumber);

    String paymentCircuitBreaker(Integer id);

}
