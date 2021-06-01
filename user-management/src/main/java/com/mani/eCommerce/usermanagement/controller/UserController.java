package com.mani.eCommerce.usermanagement.controller;


import java.net.URI;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

import com.mani.eCommerce.usermanagement.entity.Reviews;
import com.mani.eCommerce.usermanagement.entity.User;
import com.mani.eCommerce.usermanagement.service.UserServiceImpl;



@RestController
@RequestMapping("user/")
public class UserController {
  
@Autowired
 private UserServiceImpl userServiceImpl;
  

   @Autowired
   private RestTemplate restTemplate;
   @Autowired
   private LoadBalancerClient loadBalancerClient;



@PostMapping(path = "addUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody User user){
		try {
		
		return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

@GetMapping(path="getUser/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getUser(@PathVariable String id) {
try {
		User user=userServiceImpl.getUser(Long.parseLong(id));
		
		return new ResponseEntity<>(user, HttpStatus.OK);
}catch (Exception e) {
	return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

}
}
	@PostMapping(path = "addReview/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addReview(@PathVariable("id") String productId, @RequestBody Reviews review){
		
		try {
		HttpEntity<Reviews> entity= new HttpEntity<>(review);
		System.out.println("1");
		ResponseEntity<String> reponce=restTemplate.exchange(getBaseUrl("product-catlog")+"/product/addReviews/"+productId, HttpMethod.POST, entity, String.class);
		System.out.println("2");
		return new ResponseEntity<>(reponce, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		
	}

	private String getBaseUrl(String serviceId) {
		ServiceInstance instance=loadBalancerClient.choose(serviceId);
		System.out.println("-------------"+instance.getUri().toString()+"----------------------");
		return instance.getUri().toString();
	}
	
}
