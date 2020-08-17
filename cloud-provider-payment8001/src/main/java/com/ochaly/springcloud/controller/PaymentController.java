package com.ochaly.springcloud.controller;

import com.ochaly.springcloud.entity.CommonResult;
import com.ochaly.springcloud.entity.Payment;
import com.ochaly.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: creat in 2020/8/7 22:18
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        log.info("serverPort: " + port);
        int result = paymentService.add(payment);
        if (result > 0) {
            log.info("*******插入成功*******");
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("serverPort: " + port);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        }
        return new CommonResult(445, "查询失败");
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance s : instances) {
            log.info(s.getServiceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return port;
    }

    @GetMapping("/payment/zipkin")
    public String paymenyZipkin() {
        return "hi,i am payment zipkin server fallback, welcome to ochaly, O(∩_∩)O哈哈~";
    }
}
