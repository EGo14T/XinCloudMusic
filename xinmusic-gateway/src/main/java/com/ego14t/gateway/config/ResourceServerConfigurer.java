package com.ego14t.gateway.config;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/16 10:26
 * Description:
 */

//@Configuration
//@EnableWebFluxSecurity
public class ResourceServerConfigurer {

    private final String[] ALLOW_REQUEST = {"/oauth/**",
                                            "/comments/**",
                                            "/music/song/**",
                                            "/music/musiclist/*",
                                            "/music/musiclistinfo/**",
                                            "/music/collect/musiclist/**",
                                            "/music/create/musiclist/**",
                                            "/music/discover/musiclist",
                                            "/search/musiclist",
                                            "/users/register"};

    //@Bean
//    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.csrf().disable()
//                .authorizeExchange()
//                .pathMatchers(ALLOW_REQUEST).permitAll()
//                .anyExchange().authenticated()
//                .and()
//                .oauth2ResourceServer().jwt();
//        return http.build();
//    }
}
