package com.example.pdp_meal.telegram.telegramService;

import com.example.pdp_meal.telegram.Pdp_meal;
import org.springframework.stereotype.Service;

@Service
public class TelegramService {

    private final Pdp_meal bot;

    public TelegramService(Pdp_meal bot) {
        this.bot = bot;
    }

    public void register(Long chatId) {

    }

    public void getPhone(Long chatId) {

    }

    public void getFullName(Long chatId) {

    }

    public void getPassword(Long chatId) {

    }

    public void ordering(Long chatId) {

    }

    public void ordered(Long chatId) {
    }

    public void prepering(Long chatId) {

    }

    public void sendWrong(Long chatId) {

    }
}
