package com.example.pdp_meal.repository;



import com.example.pdp_meal.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthUser, Integer> {



    Optional<AuthUser> findAuthUserByChatId(String chatId);


}
