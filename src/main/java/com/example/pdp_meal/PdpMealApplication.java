package com.example.pdp_meal;

import com.example.pdp_meal.telegram.Pdp_meal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class PdpMealApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdpMealApplication.class, args);

    }

}
