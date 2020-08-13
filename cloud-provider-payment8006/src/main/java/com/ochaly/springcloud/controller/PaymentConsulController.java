package com.ochaly.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/10 11:27
 */
@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/consul")
    public String paymentConsul() {
        return "spring cloud with consul: " + port + "\t" + UUID.randomUUID().toString();
    }
}
