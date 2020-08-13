package com.ochaly.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ochaly.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/11 17:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_ok， id：" + id + "\t";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_timeout， id：" + id + "\t";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t系统繁忙或运行报错，请稍后再试。 id：" + id + "\t";
    }

    //=====服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            //是都开启断路器
            @HystrixProperty(name = "circuitBreaker.enable", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试，id：" + id;
    }
}
