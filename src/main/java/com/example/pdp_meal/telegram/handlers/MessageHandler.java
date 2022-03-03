package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.entity.AuthUser;
import com.example.pdp_meal.repository.AuthRepository;
import com.example.pdp_meal.telegram.telegramService.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageHandler {

    private final AuthRepository authRepository;
    private final TelegramService service;



    public void handle(Message message) {
        String chatId = message.getChatId().toString();
        if (message.getText().equals("/start")) {
            Optional<AuthUser> optionalAuthUser = authRepository.findAuthUserByChatId(chatId);
            if (optionalAuthUser.isEmpty()) {
                service.register(chatId);
            }
            AuthUser user = optionalAuthUser.get();
            switch (user.getState()){
                case "UNAUTHORIZED" -> service.register(chatId);
                case "PHONE" -> service.getPhone(chatId);
                case "FULLNAME" -> service.getFullName(chatId);
                case "PASSWORD" -> service.getPassword(chatId);
                case "ORDERING" -> service.ordering(chatId);
                case "ORDERED" -> service.ordered(chatId);
                case "PREPARING" -> service.preparing(chatId);
//                case "REGISTERED" -> service.getPassword(chatId);
                default -> service.sendWrong(chatId);
            }
        }
    }
}
