package com.nh.feignribbon.fallback;

import com.nh.feignribbon.api.FeignService;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/27 11:58
 * @Version 1.0
 **/
@Component
public class FeignFallback implements FeignService {

    @Override
    public String sayHello(String name) {
        return "hi "+name +", i am fallback";
    }
}
