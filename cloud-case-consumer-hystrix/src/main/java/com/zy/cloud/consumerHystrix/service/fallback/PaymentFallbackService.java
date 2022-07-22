package com.zy.cloud.consumerHystrix.service.fallback;

import com.zy.cloud.common.commonCode.ApiReturnCode;
import com.zy.cloud.common.commonResult.ApiReturn;
import com.zy.cloud.consumerHystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 对接口降级处理
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public ApiReturn queryById(Long id) {
        return new ApiReturn(ApiReturnCode.HTTP_ERROR);
    }

    @Override
    public String paymentInfo_TimeOut(Integer id, Integer timeNumber) {
        return "PaymentFallbackService fall  TimeOut 服务器出现故障,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall  OK 服务器出现故障,o(╥﹏╥)o";
    }
}
