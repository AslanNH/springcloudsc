package com.nh.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/22 10:52
 * @Version 1.0
 **/
@RestController
public class HiController {

    @Value("${server.port}")
    private  String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return "hi " + name + ", i am from port:"+port;
    }
}
