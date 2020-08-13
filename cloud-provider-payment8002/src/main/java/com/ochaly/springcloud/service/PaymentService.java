package com.ochaly.springcloud.service;

import com.ochaly.springcloud.entity.Payment;

/**
 * @Author: ouchonghui
 * @Description: 支付服务层
 * @Date: creat in 2020/8/7 22:11
 */
public interface PaymentService {
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
    Payment getPaymentById(Long id);
}
