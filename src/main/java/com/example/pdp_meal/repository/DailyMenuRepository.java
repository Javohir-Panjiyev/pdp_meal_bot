package com.example.pdp_meal.repository;

import com.example.pdp_meal.entity.DailyMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMenuRepository extends JpaRepository<DailyMenu,Integer> {

}
