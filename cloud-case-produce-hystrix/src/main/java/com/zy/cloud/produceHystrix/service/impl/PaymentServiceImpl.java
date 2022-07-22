package com.zy.cloud.produceHystrix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.cloud.common.pojo.PaymentPojo;
import com.zy.cloud.produceHystrix.mapper.PaymentMapper;
import com.zy.cloud.produceHystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentPojo> implements PaymentHystrixService {

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

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " cloud-case-produce-hystrix_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    //服务降级，对特殊接口 单独处理
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "1000")})
    @Override
    public String paymentInfo_TimeOut(Integer id, Integer timeNumber) {
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int age = 10/0; 错误代码也会触发降级
        return "线程池:" + Thread.currentThread().getName() + " cloud-case-produce-hystrix_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    //服务降级的兜底的方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "cloud-case-produce-hystrix 支付系统繁忙,o(╥﹏╥)o";
    }

}

