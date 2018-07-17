package com.server.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/3/003
 * Describe: 通过之前注入ioc容器的restTemplate来消费service-hello服务的“/hi”接口，在这里我们直接用的程序名替代了具体的url地址，
 * 在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    /**
     * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
     * fallbackMethod的返回值和参数类型需要和被@HystrixCommand注解的方法完全一致。否则会在运行时抛出异常。
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-HELLO/hi?name=" + name, String.class);
    }

    /**
     * 关闭SERVICE-HELLO,再访问hiService方法就会跳这个方法
     * @param name
     * @return
     */
    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
