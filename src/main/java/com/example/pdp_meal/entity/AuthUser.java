package com.example.pdp_meal.entity;


import com.example.pdp_meal.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String phone;
    private String chatId;
    private Status status;
    private String role;
    private String department;
    private String position;
    private boolean deleted;
    @Column(nullable = false)
    private String password;

}
