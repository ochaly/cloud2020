package com.ochaly.springcloud.controller;

import com.ochaly.springcloud.entity.CommonResult;
import com.ochaly.springcloud.entity.Payment;
import com.ochaly.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/8 09:56
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        if (serviceInstances == null && serviceInstances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(serviceInstances);
        return restTemplate.getForObject(serviceInstance.getUri() + "/apyment/lb", String.class);
    }

}
