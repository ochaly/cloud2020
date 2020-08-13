package com.ochaly.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/11 17:20
 */
public interface PaymentService {
    /**
     * 正常访问
     *
     * @param id id
     * @return 信息
     */
    String paymentInfoOk(Integer id);

    /**
     * 异常访问
     *
     * @param id id
     * @return 信息
     */
    String paymentInfoTimeOut(Integer id);

    /**
     * 服务熔断
     *
     * @param id id
     * @return 信息
     */
    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
