package com.example.pdp_meal.repository;


import com.example.pdp_meal.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthUser,Integer> {
}
