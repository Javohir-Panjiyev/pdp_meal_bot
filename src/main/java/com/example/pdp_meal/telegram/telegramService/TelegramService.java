package com.example.pdp_meal.telegram.telegramService;

import com.example.pdp_meal.telegram.Pdp_meal;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class TelegramService {

    public Pdp_meal bot;

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

    public void preparing(Long chatId) {

    }

    public void sendWrong(Long chatId) {
        SendMessage msg = new SendMessage(chatId.toString(), "Wrong option");
        bot.executeMessage(msg);
    }
}
