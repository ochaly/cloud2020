package com.ochaly.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: create in 2020/8/11 20:00
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    /**
     * 正常访问
     *
     * @param id id
     * @return 信息
     */
    @GetMapping("/payment/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * 异常访问
     *
     * @param id id
     * @return 信息
     */
    @GetMapping("/payment/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
