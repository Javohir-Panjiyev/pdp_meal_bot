package com.example.pdp_meal.repository;

import com.example.pdp_meal.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
