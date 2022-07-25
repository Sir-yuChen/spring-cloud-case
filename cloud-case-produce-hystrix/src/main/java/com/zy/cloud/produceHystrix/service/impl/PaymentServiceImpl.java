package com.zy.cloud.produceHystrix.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.cloud.common.pojo.PaymentPojo;
import com.zy.cloud.produceHystrix.mapper.PaymentMapper;
import com.zy.cloud.produceHystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

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
    public String paymentTimeOutFallbackMethod(Integer id, Integer timeNumber) {
        return "cloud-case-produce-hystrix 支付系统繁忙,o(╥﹏╥)o";
    }

    ///熔断
    //在10秒内，发生20次以上的请求时，假如错误率达到50%以上，则断路器将被打开。（当一个窗口期过去的时候，断路器将变成半开（HALF-OPEN）状态，如果这时候发生的请求正常，则关闭，否则又打开）
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }
//兜底降级的方法
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
    /*
    *
    * 断路器的窗口期内能够容忍的错误百分比阈值，默认为50（也就是说默认容忍50%的错误率）。打个比方，假如一个窗口期内，发生了100次服务请求，其中50次出现了错误。
    * 在这样的情况下，断路器将会被打开。在该窗口期结束之前，即使第51次请求没有发生异常，也将被执行fallback逻辑。
    *
    *
    * */


}

