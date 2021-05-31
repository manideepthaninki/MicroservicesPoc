package com.mani.eCommerce.productcatlog;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ProductCatlogApplication {

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductCatlogApplication.class, args);
	}

}
