package com.ochaly.springcloud.service.impl;

import com.ochaly.springcloud.entity.Payment;
import com.ochaly.springcloud.mapper.PaymentMapper;
import com.ochaly.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/7 22:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {
        return paymentMapper.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
