package com.example.pdp_meal.repository;

import com.example.pdp_meal.entity.DailyMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyMenuRepository extends JpaRepository<DailyMenu,Integer> {

}
