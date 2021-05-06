package com.nh.gateway.filter.local;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Author nihh
 * @Date 2021/5/6 16:22
 * @Version 1.0
 **/
@Component
public class AFilter extends AbstractGatewayFilterFactory<Object> implements GatewayFilter , Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getPath().pathWithinApplication().value();
        System.out.println("请求URL:" + url);
        System.out.println("method:" + exchange.getRequest().getMethod());

        if (StringUtils.isBlank(url))
        {
            //终止请求，直接回应
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return new AFilter();
    }
}
