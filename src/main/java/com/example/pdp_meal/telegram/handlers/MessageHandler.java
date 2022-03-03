package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.entity.AuthUser;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.repository.AuthUserRepository;
import com.example.pdp_meal.telegram.telegramService.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Objects;
import java.util.Optional;

import static com.example.pdp_meal.telegram.BotProcess.UserState;

@Component
@RequiredArgsConstructor
public class MessageHandler {

    private final AuthUserRepository authRepository;
    private final TelegramService service;


    public void handle(Message message) {
        String chatId = message.getChatId().toString();
        Optional<AuthUser> optionalAuthUser = authRepository.findAuthUserByChatId(chatId);
//        if (optionalAuthUser.isEmpty() ||
//                !Objects.equals(optionalAuthUser.get().getState(), State.REGISTERED)) {
//            service.register(message, UserState.get(chatId));
//        }
        if (message.getText().equals("/start")) {
            AuthUser user = optionalAuthUser.get();
//            switch (user.getState()){
//                case "ORDERING" -> service.ordering(chatId);
//                case "ORDERED" -> service.ordered(chatId);
//                case "PREPARING" -> service.preparing(chatId);
////                case "REGISTERED" -> service.getPassword(chatId);
//                default -> service.sendWrong(chatId);
//            }
        }
    }
}
