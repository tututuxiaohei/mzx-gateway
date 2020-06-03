package com.mzx.gateway.filter.factory;

import com.mzx.gateway.filter.CustomizeGatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public abstract class AbstractCustomizeGatewayFilterFactory<T> extends AbstractGatewayFilterFactory<T> {

    public String name() {
        return this.getClass().getSimpleName();
    }

    public GatewayFilter apply(final T config) {
        return new CustomizeGatewayFilter() {

            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                //是不是要跳过过滤工厂
                if (skipPresent(config, exchange)) {
                    chain.filter(exchange);
                }
                return doApply(config, exchange, chain);
            }

            public int getOrder() {
                return doGetOrder();
            }
        };
    }

    protected abstract int doGetOrder();

    protected abstract Mono<Void> doApply(T config, ServerWebExchange exchange, GatewayFilterChain chain);

    protected abstract boolean skipPresent(T config, ServerWebExchange exchange);


}
