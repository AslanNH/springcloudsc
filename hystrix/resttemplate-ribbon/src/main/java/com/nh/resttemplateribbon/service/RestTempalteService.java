package com.nh.resttemplateribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/27 9:51
 * @Version 1.0
 **/
@Service
public class RestTempalteService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiFallback")
    public String hi(String name){
        return restTemplate.getForObject("http://eurekaclient/hi?name="+name,String.class);
    }

    public String hiFallback(String name){
        return "hi "+name+",i am hiFallback";
    }
}
