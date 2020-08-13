package com.ochaly.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.ochaly.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: create in 2020/8/11 19:18
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info(result);
        return result;
    }

    //=====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result: " + result);
        return result;
    }
}
