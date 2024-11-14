package com.user.resilience4j.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String name;
    private String category;
    private String color;
    private int price;
    
    public OrderDTO() {
    	
    }
    
	public OrderDTO(String name, String category, String color, int price) {
		super();
		this.name = name;
		this.category = category;
		this.color = color;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
    
}
		
		
	    
	    


