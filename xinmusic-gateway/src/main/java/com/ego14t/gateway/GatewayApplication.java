package com.ego14t.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author EGo1ST
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class, args);

    }

    //已改为yml配置文件配置
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                // basic proxy
////                .route(r -> r
////                        .path("/my/**")
////                        .filters(f->f.stripPrefix(1).prefixPath("/resource"))
////                        .uri("lb://XinMusic-Feign/**"))
}
