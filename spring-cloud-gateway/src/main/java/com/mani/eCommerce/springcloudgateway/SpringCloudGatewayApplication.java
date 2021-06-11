package com.mani.eCommerce.springcloudgateway;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.xmlpull.v1.XmlPullParserException;




@SpringBootApplication
@EnableEurekaClient
@CrossOrigin("*")

public class SpringCloudGatewayApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudGatewayApplication.class);

	
	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}


	/*
	 * @Bean public Docket createRestApi(){ return new
	 * Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select() // api
	 * scanning range
	 * .apis(RequestHandlerSelectors.basePackage("com.fh.controller")).paths(
	 * PathSelectors.any()).build(); .paths(PathSelectors.any()).build(); }
	 * 
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("API Gateway Interface documentation") // Document
	 * name .description(" API Gateway Interface documentation") // Document
	 * description .version("2.0") //Version number .build(); }
	 */
	
	@Autowired
	RouteDefinitionLocator locator;
	
	
	@Bean
	public List<GroupedOpenApi> apis() {
		List<GroupedOpenApi> groups = new ArrayList<>();
		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
		
		
		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
			String name = routeDefinition.getId().replaceAll("-service", "");
			groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").setGroup(name).build());
		});
		
		groups.stream().forEach(a->{
		
			LOGGER.info("------########Spring cloud GatewayLog ########---------");
		LOGGER.info(a.getGroup());	
		});
		
		return groups;
	}
	
	/*
	 * @Bean public RouteLocator routeLocator(RouteLocatorBuilder builder) { return
	 * builder.routes().route(a ->
	 * a.path("/product/**").uri("http://localhost:9091/")) .route(a ->
	 * a.path("/user/**").uri("http://localhost:9093/")).build(); }
	 */
	
 
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);

	}

}
