package com.nh.feign.controller;

import com.nh.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/25 18:00
 * @Version 1.0
 **/
@RestController
public class HiController {
    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String sayHello(String name){
        return hiService.sayHello(name);
    }
}
