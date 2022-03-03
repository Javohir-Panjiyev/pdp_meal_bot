package com.example.pdp_meal.telegram.telegramService;



import com.example.pdp_meal.telegram.BotProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class TelegramService {

    private final BotProcess bot;

    public void register(String chatId) {
        SendMessage message =new SendMessage(chatId,"ishladi");
        bot.executeMessage(message);


    }

    public void getPhone(String chatId) {

    }

    public void getFullName(String chatId) {

    }

    public void getPassword(String chatId) {

    }

    public void ordering(String chatId) {

    }

    public void ordered(String chatId) {
    }

    public void preparing(String chatId) {

    }

    public void sendWrong(String chatId) {
        SendMessage msg = new SendMessage(chatId, "Wrong option");
        bot.executeMessage(msg);
    }
}
