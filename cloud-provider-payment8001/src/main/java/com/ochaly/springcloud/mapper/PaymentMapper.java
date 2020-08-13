package com.ochaly.springcloud.mapper;

import com.ochaly.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ouchonghui
 * @Description: 支付数据操作层
 * @Date: creat in 2020/8/7 21:45
 */
@Mapper
public interface PaymentMapper {
    /**
     * 新增
     *
     * @param payment 支付实体
     * @return 返回
     */
    int add(Payment payment);

    /**
     * 通过id查询
     *
     * @param id id
     * @return 支付数据
     */
    Payment getPaymentById(@Param("id") Long id);
}
