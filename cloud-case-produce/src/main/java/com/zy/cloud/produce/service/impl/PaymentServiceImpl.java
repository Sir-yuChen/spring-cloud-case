package com.zy.cloud.produce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.cloud.common.pojo.PaymentPojo;
import com.zy.cloud.produce.mapper.PaymentMapper;
import com.zy.cloud.produce.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service业务逻辑处理 :
 *
 * @author
 * @since 2021-06-30
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentPojo> implements PaymentService {

    @Resource
    private PaymentMapper paymentPojoMapper;


    @Override
    public int create(PaymentPojo dept) {
        int insert = paymentPojoMapper.insert(dept);
        return insert;
    }

    @Override
    public PaymentPojo queryById(Long id) {
        PaymentPojo paymentPojo = paymentPojoMapper.selectById(id);
        return paymentPojo;
    }
}

