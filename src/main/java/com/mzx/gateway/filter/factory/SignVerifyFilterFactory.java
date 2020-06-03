package com.mzx.gateway.filter.factory;

import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * sign校验 验证过滤工厂
 * todo 注入验签
 * todo 定义过滤顺序
 * todo 定义验签流程
 * todo 配置灵活
 * todo 全局异常
 */
public class SignVerifyFilterFactory extends AbstractCustomizeGatewayFilterFactory{

    protected int doGetOrder() {
        return 0;
    }

    protected Mono<Void> doApply(Object config, ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }

    protected boolean skipPresent(Object config, ServerWebExchange exchange) {
        return false;
    }
}
