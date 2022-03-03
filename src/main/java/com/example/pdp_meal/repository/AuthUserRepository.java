package com.example.pdp_meal.repository;



import com.example.pdp_meal.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {




    AuthUser findByUsername(String username);

    @Query("from AuthUser a where a.chatId=:id")
    AuthUser findByChatId(@Param("id") String id);
}
