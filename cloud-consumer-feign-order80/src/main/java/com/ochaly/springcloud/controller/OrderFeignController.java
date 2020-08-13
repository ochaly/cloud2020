package com.ochaly.springcloud.controller;

import com.ochaly.springcloud.entity.CommonResult;
import com.ochaly.springcloud.entity.Payment;
import com.ochaly.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/11 10:21
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
