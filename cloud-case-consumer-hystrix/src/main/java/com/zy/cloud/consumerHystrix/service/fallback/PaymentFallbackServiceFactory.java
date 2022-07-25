package com.zy.cloud.consumerHystrix.service.fallback;

import com.zy.cloud.common.commonCode.ApiReturnCode;
import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.consumerHystrix.service.PaymentHystrixService;
import feign.hystrix.FallbackFactory;


public class PaymentFallbackServiceFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        System.out.println("fallback; reason was: {}" + throwable.getMessage());
        return new PaymentHystrixService() {
            @Override
            public ApiReturn queryById(Long id) {
                return new ApiReturn(ApiReturnCode.HTTP_ERROR);
            }

            @Override
            public String paymentInfo_TimeOut(Integer id, Integer timeNumber) {
                return "PaymentFallbackServiceFactory 降级 fall  TimeOut 服务器出现故障,o(╥﹏╥)o";
            }

            @Override
            public String paymentInfo_OK(Integer id) {
                return "PaymentFallbackServiceFactory 降级 fall  OK 服务器出现故障,o(╥﹏╥)o";
            }

            @Override
            public String paymentCircuitBreaker(Integer id) {
                return "PaymentFallbackServiceFactory 降级 fall  paymentCircuitBreaker 服务器出现故障,o(╥﹏╥)o";
            }
        };
    }
}
