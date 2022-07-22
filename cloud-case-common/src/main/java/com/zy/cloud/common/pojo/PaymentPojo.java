package com.zy.cloud.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
*  payment : 
*  @author zy
*  @since 2022-07-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("payment")
public class PaymentPojo extends Model<PaymentPojo> implements Serializable {

private static final long serialVersionUID = 1L;

        /**
        * 主键 : id  ID
        */
     @TableId(value = "id", type = IdType.AUTO)
        private Long id;

        /**
        * serial: 
        */
        private String serial;

@Override
protected Serializable pkVal() {
return this.id;
}
}

