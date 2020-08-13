package com.ochaly.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/10 11:33
 */
@RestController
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}
