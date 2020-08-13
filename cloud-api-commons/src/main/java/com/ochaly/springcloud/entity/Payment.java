package com.ochaly.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: ouchonghui
 * @Description: 支付实体类
 * @Date: creat in 2020/8/7 21:32
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
