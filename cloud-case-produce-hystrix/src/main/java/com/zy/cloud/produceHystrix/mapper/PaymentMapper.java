package com.zy.cloud.produceHystrix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.cloud.common.pojo.PaymentPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
*  mapper接口 : 
*  @author zy
*  @since 2022-07-21
*/
@Mapper
@Repository
public interface PaymentMapper extends BaseMapper<PaymentPojo> {

}
