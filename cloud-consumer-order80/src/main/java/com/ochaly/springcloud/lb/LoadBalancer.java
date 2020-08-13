package com.ochaly.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: ouchonghui
 * @Description: 轮播算法
 * @Date: creat in 2020/8/10 20:05
 */
public interface LoadBalancer {
    /**
     * 轮播算法
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
