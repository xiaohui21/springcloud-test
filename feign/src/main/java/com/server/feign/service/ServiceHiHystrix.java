package com.server.feign.service;

import org.springframework.stereotype.Component;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/3/003
 * Describe:
 */
@Component
public class ServiceHiHystrix implements FeignService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
