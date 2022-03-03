package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.entity.AuthUser;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.repository.AuthRepository;
import com.example.pdp_meal.telegram.emojis.Emojis;
import com.example.pdp_meal.telegram.telegramService.ProcessService;
import com.example.pdp_meal.telegram.telegramService.RegisterService;
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

    private final AuthRepository authRepository;


    private final TelegramService service;
    private final RegisterService registerService;
    private final ProcessService processService;


    public void handle(Message message) {
        String chatId = message.getChatId().toString();
        Optional<AuthUser> optionalAuthUser = authRepository.findAuthUserByChatId(chatId);
        if (message.getText().equals("/start")) {
            if (!Objects.equals(optionalAuthUser.get().getState(), State.REGISTERED)) {
                registerService.register(message, UserState.get(chatId));
            }
            else processService.start(message);
        }

        else if (message.getText().equals("/help") && message.getText().equals(Emojis.HELP + "Help")) {
            service.help(chatId);
        }

        else if (message.getText().equals("/support") && message.getText().equals(Emojis.SUPPORT + "Support")) {
            service.support(chatId);
        }

        else if (message.getText().equals("/feedback") && message.getText().equals(Emojis.FEEDBACK + "Feedback")) {
            service.feedback(chatId);
        }

        else if (message.getText().equals(Emojis.GO_BACK + "Back")) {
            service.mainMenu(chatId);
        }

    }
}
