package com.ochaly.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/10 10:35
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/zk")
    public String paymentZk() {
        return "spring cloud with zookeeper: " + port + "\t" + UUID.randomUUID().toString();
    }
}
