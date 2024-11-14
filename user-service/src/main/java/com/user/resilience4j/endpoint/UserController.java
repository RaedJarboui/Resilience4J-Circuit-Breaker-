package com.user.resilience4j.endpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.resilience4j.dto.OrderDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class UserController {
	
	private final String BASE_URL = "http://localhost:8081/orders";
	
	public static final String  USER_SERVICE="userService";
	
	 @Autowired
	    @Lazy
	    private RestTemplate restTemplate;
	
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@SuppressWarnings("unchecked")
	@CircuitBreaker(name=USER_SERVICE,fallbackMethod = "getDefaultOrders")
	@GetMapping("/getOrders")
	public List<OrderDTO> getOrders(){
		return (List<OrderDTO>) restTemplate.getForObject(BASE_URL + "/list", Object.class);
		
	
	}
	
	 public List<OrderDTO> getDefaultOrders(Exception e){
	        return List.of(
	                new OrderDTO("LED TV", "electronics", "white", 45000),
	                new OrderDTO("Headset", "electronics", "black", 7000),
	                new OrderDTO("Sound bar", "electronics", "black", 13000),
	                new OrderDTO("Puma Shoes", "foot wear", "black & white", 4600),
	                new OrderDTO("Vegetable chopper", "kitchen", "blue", 999),
	                new OrderDTO("Oven Gloves", "kitchen", "gray", 745)
	        );
	    }
	
	@GetMapping("/getOrders/{category}")
	public List<OrderDTO> getOrdersByCategory(@PathVariable String category){
		return (List<OrderDTO>) new RestTemplate().getForObject(BASE_URL + "/" +category, Object.class);

	
	}
	
	
	
	
	

}
