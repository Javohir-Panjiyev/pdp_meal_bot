package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.entity.AuthUser;
import com.example.pdp_meal.repository.AuthRepository;
import com.example.pdp_meal.telegram.telegramService.TelegramService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Component
public class MessageHandler {

    private final AuthRepository authRepository;
    private final TelegramService service;

    public MessageHandler(AuthRepository authRepository, TelegramService service) {
        this.authRepository = authRepository;
        this.service = service;
    }

    public void handle(Message message) {
        Long chatId = message.getChatId();
        if (message.getText().equals("/start")) {
            Optional<AuthUser> optionalAuthUser = authRepository.findAuthUserByChatId(chatId.toString());
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
                case "PREPARING" -> service.prepering(chatId);
//                case "REGISTERED" -> service.getPassword(chatId);
                default -> service.sendWrong(chatId);
            }
        }
    }
}
