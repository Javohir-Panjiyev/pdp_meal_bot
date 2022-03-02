package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.telegram.pdp_meal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageHandler {

    private static final pdp_meal BOT = pdp_meal.getInstance();
    private static MessageHandler instance=new MessageHandler();

    public static MessageHandler getInstance() {
        return instance;
    }

    public void handle(Message message){
        String chatId = message.getChatId().toString();

        if (message.getText().equals("/start")){
            SendMessage sendMessage=new SendMessage(chatId,"salom");
            BOT.executeMessage(sendMessage);
        }


    }
}
