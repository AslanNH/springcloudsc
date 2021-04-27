package com.nh.feignribbon.service;

import com.nh.feignribbon.api.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/25 17:58
 * @Version 1.0
 **/
@Service
public class HiService {
    @Autowired
    private FeignService feignService;

    public String sayHello(String name){
        return feignService.sayHello(name);
    }
}
