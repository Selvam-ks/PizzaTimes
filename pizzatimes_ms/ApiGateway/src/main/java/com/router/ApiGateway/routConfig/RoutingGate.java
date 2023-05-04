package com.router.ApiGateway.routConfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


@Configuration
@CrossOrigin
public class RoutingGate {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec
                                .path("/pizzaTimes/user/**")
                                .uri("http://localhost:17899"))
                .route(predicateSpec -> predicateSpec
                                .path("/pizzaTimes/product/**")
                                .uri("http://localhost:10801"))
                .build();
    }
}
