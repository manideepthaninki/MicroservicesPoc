package com.mani.eCommerce.productcatlog.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mani.eCommerce.productcatlog.entity.Product;
import com.mani.eCommerce.productcatlog.entity.Reviews;
import com.mani.eCommerce.productcatlog.services.ProductService;
import com.mani.eCommerce.productcatlog.services.ProductServiceImpl;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductServiceImpl productService;

	@PostMapping(path = "addProduct",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createProduct(@RequestBody Product input) {

		try {
			Product product = productService.createProduct(input);
			return new ResponseEntity<>(product, HttpStatus.BAD_GATEWAY);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}

	@PostMapping(path = "addReviews/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addReview(@PathVariable("id") String id, @RequestBody Reviews input) {

		try {
			
			String sucessMessage = productService.addreview(Long.parseLong(id), input);
			System.out.println("10");
			return new ResponseEntity<>(sucessMessage, HttpStatus.BAD_GATEWAY);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/callUser")
	public ResponseEntity<?> getUser() {

		try {
			User user = (User) restTemplate.getForObject(getbaseUrl("user-service") + "/user/getUser/1", User.class);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	private String getbaseUrl(String serviceId) {
		ServiceInstance instace = loadBalancerClient.choose(serviceId);
		return instace.getUri().toString();
	}

}
