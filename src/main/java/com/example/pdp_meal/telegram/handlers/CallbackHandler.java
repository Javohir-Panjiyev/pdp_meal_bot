package com.example.pdp_meal.telegram.handlers;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CallbackHandler {

    private static CallbackHandler instance=new CallbackHandler();

    public void handle(CallbackQuery callbackQuery){


    }

    public static CallbackHandler getInstance() {
        return instance;
    }
}
