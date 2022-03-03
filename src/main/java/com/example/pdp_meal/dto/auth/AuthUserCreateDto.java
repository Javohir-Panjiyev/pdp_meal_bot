package com.example.pdp_meal.dto.auth;

import com.example.pdp_meal.dto.BaseDto;
import com.example.pdp_meal.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class AuthUserCreateDto implements BaseDto {

    private String phone;
    private String username;
    private String password;
    private String chatId;
    private String role;
    private String department;
    private String position;
    private boolean active;
}
