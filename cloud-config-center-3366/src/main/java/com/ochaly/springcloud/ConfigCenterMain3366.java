package com.ochaly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ouchonghui
 * @Description:
 * @Date: create in 2020/8/16 11:09
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCenterMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3366.class, args);
    }
}
