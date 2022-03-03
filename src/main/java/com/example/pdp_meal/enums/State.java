package com.example.pdp_meal.enums;

import lombok.Getter;

@Getter
public enum State {
    UNAUTHORIZED("UNAUTHORIZED"),
    PHONE("PHONE"),
    FULLNAME("FULLNAME"),
    PASSWORD("PASSWORD"),
    REGISTERED("REGISTERED"),
    ORDERING("ORDERING"),
    ORDERED("ORDERED"),
    PREPARING("PREPARING");

    private final String name;

    State(String name) {
        this.name = name;
    }
}
