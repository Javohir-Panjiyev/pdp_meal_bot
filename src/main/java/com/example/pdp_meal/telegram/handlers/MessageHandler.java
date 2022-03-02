package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.entity.AuthUser;
import com.example.pdp_meal.repository.AuthRepository;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import com.example.pdp_meal.telegram.pdp_meal;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;


import java.util.Optional;

public class MessageHandler {

    private static final pdp_meal BOT = pdp_meal.getInstance();

      private  final AuthRepository authRepository;

    public MessageHandler(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }




    public void handle(Message message){
        String chatId = message.getChatId().toString();

        if (message.getText().equals("/start")){
            Optional<AuthUser> user = authRepository.findAuthUserByChatId(chatId);
            if (user.isEmpty()){
                MarkupBoards.sharePhoneNumber(chatId);
            }
            else {
                SendMessage sendMessage=new SendMessage(chatId,"Welcome to our bot !");
                BOT.executeMessage(sendMessage);
            }
        }


    }
}
