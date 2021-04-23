package com.nh.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/testRest")
    public String testRest(){
        return restTemplate.getForObject("https://www.baidu.com/",String.class);
    }
}
