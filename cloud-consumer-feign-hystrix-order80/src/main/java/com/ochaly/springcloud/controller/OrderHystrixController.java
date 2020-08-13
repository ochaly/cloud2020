package com.ochaly.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ochaly.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: create in 2020/8/11 20:03
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable Integer id) {
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info(result);
        return result;
    }

    @GetMapping("/consumer/payment/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable Integer id) {
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        log.info(result);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t系统繁忙或运行报错，请稍后再试。 id：" + id + "\t";
    }

    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试！！！";
    }
}
