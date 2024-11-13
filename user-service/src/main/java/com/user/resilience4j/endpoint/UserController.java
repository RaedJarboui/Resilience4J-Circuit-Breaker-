package com.user.resilience4j.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.resilience4j.dto.OrderDTO;

@RestController
public class UserController {
	
	private final String BASE_URL = "http://localhost:8081/orders";
	
	 @Autowired
	    @Lazy
	    private RestTemplate restTemplate;
	
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getOrders")
	public List<OrderDTO> getOrders(){
		return (List<OrderDTO>) restTemplate.getForObject(BASE_URL + "/list", Object.class);
		
	
	}
	
	@GetMapping("/getOrders/{category}")
	public List<OrderDTO> getOrdersByCategory(@PathVariable String category){
		return (List<OrderDTO>) new RestTemplate().getForObject(BASE_URL + "/" +category, Object.class);

	
	}
	
	
	
	
	

}
