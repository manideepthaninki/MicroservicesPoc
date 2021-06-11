package com.mani.eCommerce.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
@EnableSwagger2
@OpenAPIDefinition(info = 
@Info(title = "User API", version = "1.0", description = "Documentation User API v1.0"))
public class UserManagementApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
	
	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.mani.eCommerce.usermanagement"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("User API").description("Documentation User API v1.0").build());
	}
	
	
	
	/*
	 * @Bean public Docket createRestApi(){ return new
	 * Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select() // api
	 * scanning range
	 * .apis(RequestHandlerSelectors.basePackage("com.mani.eCommerce.usermanagement"
	 * )).paths(PathSelectors.any()).build(); }
	 * 
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("User-Management service API Interface documentation")
	 * // Document name
	 * .description("User-Management service API Interface documentation") //
	 * Document description .version("2.0") //Version number .build(); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
