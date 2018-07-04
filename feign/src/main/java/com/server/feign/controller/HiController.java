package com.server.feign.controller;

import com.server.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/3/003
 * Describe:
 */
@RestController
public class HiController {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return feignService.sayHiFromClientOne(name);
    }

}
