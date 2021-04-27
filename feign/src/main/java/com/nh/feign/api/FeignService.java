package com.nh.feign.api;

import com.nh.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eurekaclient", configuration = FeignConfig.class)
public interface FeignService {

    @GetMapping("/hi")
    String sayHello(@RequestParam String name);
}
