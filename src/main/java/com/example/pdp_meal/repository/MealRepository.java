package com.example.pdp_meal.repository;

import com.example.pdp_meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Integer> {
}
