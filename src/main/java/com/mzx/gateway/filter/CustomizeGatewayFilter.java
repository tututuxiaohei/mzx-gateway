package com.mzx.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.core.Ordered;

public interface CustomizeGatewayFilter extends GatewayFilter, Ordered {
}
