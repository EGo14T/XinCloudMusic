package com.ego14t.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/16 10:26
 * Description:
 */

@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfigurer {

    private final String[] ALLOW_REQUEST = {"/comments/**",
                                            "/my/musiclist/*",
                                            "/my/musiclistinfo/**",
                                            "/my/discover/musiclist",
                                            "/oauth/**",
                                            "/users/register"};

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf().disable()
                .authorizeExchange()
                .pathMatchers(ALLOW_REQUEST).permitAll()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer().jwt();
        return http.build();
    }
}
