package com.nh.feign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author nihh
 * @Date 2021/4/25 17:52
 * @Version 1.0
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetrter(){
        return new Retryer.Default(100,TimeUnit.SECONDS.toMillis(1L),5);
    }
}
