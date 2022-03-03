package com.example.pdp_meal.telegram.telegramService;


import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final BotProcess BOT;

    public void start(Message message) {
        String chatId = message.getChatId().toString();
        SendMessage message1 = new SendMessage(chatId, " Menu");
        message1.setReplyMarkup(MarkupBoards.mainMenu());
        BOT.executeMessage(message1);


    }
}
