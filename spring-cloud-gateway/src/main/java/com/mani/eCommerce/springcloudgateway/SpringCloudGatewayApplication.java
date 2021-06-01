package com.mani.eCommerce.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayApplication {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes().route(a -> a.path("/product/**").uri("http://localhost:9091/"))
				.route(a -> a.path("/user/**").uri("http://localhost:9093/")).build();

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);

	}

}
