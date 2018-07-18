package com.server.ribbon.contoller;

import com.server.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/3/003
 * Describe:
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.helloService(name);
    }
}
