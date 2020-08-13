package com.ochaly.springcloud.service;

import com.ochaly.springcloud.entity.CommonResult;
import com.ochaly.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/11 10:16
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 通过id查询
     *
     * @param id id
     * @return 支付数据
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
