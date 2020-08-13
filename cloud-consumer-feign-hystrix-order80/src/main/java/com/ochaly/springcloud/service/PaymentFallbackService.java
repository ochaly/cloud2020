package com.ochaly.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: create in 2020/8/12 09:38
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "---------PaymentFallbackService fall back ok-----------";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "---------PaymentFallbackService fall back timeout-----------";
    }
}
