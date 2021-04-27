package com.nh.feignribbon.api;

import com.nh.feignribbon.fallback.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eurekaclient",fallback = FeignFallback.class)
public interface FeignService {

    @GetMapping("/hi")
    String sayHello(@RequestParam String name);
}
