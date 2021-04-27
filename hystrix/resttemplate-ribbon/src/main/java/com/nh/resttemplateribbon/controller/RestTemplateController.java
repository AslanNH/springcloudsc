package com.nh.resttemplateribbon.controller;

import com.nh.resttemplateribbon.service.RestTempalteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/27 10:15
 * @Version 1.0
 **/
@RestController
public class RestTemplateController {
    @Autowired
    private RestTempalteService restTempalteService;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hi")
    public String hi(String name){
        return restTempalteService.hi(name);
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
