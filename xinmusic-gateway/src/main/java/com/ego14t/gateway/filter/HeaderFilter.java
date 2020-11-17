package com.ego14t.gateway.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ego14t.gateway.pojo.UserInfo;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Component
public class HeaderFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String jwt = headers.getFirst("Authorization");

        if (jwt == null){
            return chain.filter(exchange.mutate().request(request).build());
        }

        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
            httpHeader.set("userId", DeCodeJWT(jwt));
        };

        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().headers(httpHeaders).build();
        exchange.mutate().request(serverHttpRequest).build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return -200;
    }

    private String DeCodeJWT(String jwt) {
        //取出jwt
        jwt = jwt.replace("Bearer ","");
        if (jwt.equals("")){
            return null;
        }
        //解析jwt
        DecodedJWT decodedJWT = JWT.decode(jwt);
        //映射jwt中的信息为UserInfo对象
        Claim user = decodedJWT.getClaim("user");
        UserInfo userInfo = user.as(UserInfo.class);
        return userInfo.getId();
    }
}
