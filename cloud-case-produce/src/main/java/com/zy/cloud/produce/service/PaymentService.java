package com.zy.cloud.produce.service;

import com.zy.cloud.common.pojo.PaymentPojo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
*  Service接口 : 
*  @author zy
*  @since 2022-07-21
*/
public interface PaymentService extends IService<PaymentPojo> {

    int create(PaymentPojo dept);

    PaymentPojo queryById(Long id);

}
