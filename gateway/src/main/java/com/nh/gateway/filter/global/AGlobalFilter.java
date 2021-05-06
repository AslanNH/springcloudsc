package com.nh.gateway.filter.global;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Author nihh
 * @Date 2021/5/6 16:11
 * @Version 1.0
 **/
@Configuration
public class AGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("AFilter前置逻辑");
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
        {
            System.out.println("AFilter后置逻辑");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
