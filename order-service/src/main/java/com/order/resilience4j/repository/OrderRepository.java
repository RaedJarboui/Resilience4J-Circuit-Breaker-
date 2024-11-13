package com.order.resilience4j.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.resilience4j.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByCategory(String category);
}
