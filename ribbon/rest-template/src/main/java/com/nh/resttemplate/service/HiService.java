package com.nh.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/25 15:48
 * @Version 1.0
 **/
@Service
public class HiService {

    @Autowired
    private RestTemplate restTemplate;

    public String testRibbon(String name){
        return restTemplate.getForObject("http://eurekaclient/hi?name="+name,String.class);
    }
}
