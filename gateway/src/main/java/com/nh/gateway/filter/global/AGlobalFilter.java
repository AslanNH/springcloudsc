package com.nh.gateway.filter.global;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Tracer tracer;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 增加一些自定义信息
        tracer.currentSpanCustomizer().tag("操作人","黑崎一护");
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
        {

        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
