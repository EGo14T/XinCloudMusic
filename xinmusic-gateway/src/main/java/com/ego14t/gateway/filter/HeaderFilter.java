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

import java.util.Map;
import java.util.function.Consumer;

@Component
public class HeaderFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        //UserInfo user = DeCodeJWT(headers.getFirst("Authorization"));
        String jwt = headers.getFirst("Authorization");

        if (jwt.isEmpty()){
            return chain.filter(exchange.mutate().request(request).build());
        }

        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
            httpHeader.set("userInfo", DeCodeJWT(jwt));
        };

        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().headers(httpHeaders).build();
        exchange.mutate().request(serverHttpRequest).build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return -200;
    }

    private<T> T DeCodeJWT(String jwt) {
        jwt = jwt.replace("Bearer ","");

        DecodedJWT decodedJWT = JWT.decode(jwt);
        Claim user = decodedJWT.getClaim("user");
        Map<String, Object> stringObjectMap = user.asMap();
        System.out.println(stringObjectMap.get("name"));

        return (T)"123";
    }
}
