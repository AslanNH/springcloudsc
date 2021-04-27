package com.nh.resttemplate.controller;

import com.nh.resttemplate.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/23 11:49
 * @Version 1.0
 **/
@RestController
public class RestTestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HiService hiService;



    @GetMapping("/testRest")
    public String testRest(){
        return restTemplate.getForObject("https://www.baidu.com/",String.class);
    }

    @GetMapping("/testRibbon")
    public String testRibbon(String name){
        return restTemplate.getForObject("http://eurekaclient/hi?name="+name,String.class);
        //return hiService.testRibbon(name);
    }
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/testLoadBalance")
    public String testLoadBalance(){
        ServiceInstance eureakclient = loadBalancerClient.choose("eurekaclient");
        System.out.println(eureakclient.toString());
        return eureakclient.toString();
    }
}
