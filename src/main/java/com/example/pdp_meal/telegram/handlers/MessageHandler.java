package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.dto.auth.AuthUserDto;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.repository.AuthUserRepository;
import com.example.pdp_meal.service.auth.AuthUserService;
import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import com.example.pdp_meal.telegram.emojis.Emojis;
import com.example.pdp_meal.telegram.telegramService.ProcessService;
import com.example.pdp_meal.telegram.telegramService.RegisterService;
import com.example.pdp_meal.telegram.telegramService.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Objects;

import static com.example.pdp_meal.telegram.BotProcess.UserState;
import static com.example.pdp_meal.telegram.BotProcess.userHashMap;

@Component
@RequiredArgsConstructor
public class MessageHandler {

    private final AuthUserRepository authRepository;


    private final TelegramService service;
    private final RegisterService registerService;
    private final AuthUserService userService;
    private final ProcessService processService;
    private final BotProcess BOT;


    public void handle(Message message) {
        String chatId = message.getChatId().toString();

        AuthUserDto user = userService.getByChatId(chatId);
        if (Objects.nonNull(user)){
            UserState.put(chatId,State.START.getName());
        }
//        AuthUserCreateDto userCreateDto1 = userHashMap.get(chatId);
//        userCreateDto1.setChatId(chatId);
//        userHashMap.put(chatId, userCreateDto1);


//
        if (message.hasContact() || (message.getText().equals("/start") && Objects.isNull(user)) ||
                !UserState.get(chatId).equals(State.START.getName())) {
            registerService.register(message);
        } else if (message.getText().equals("/start") && Objects.nonNull(user)) {
            SendMessage message1 = new SendMessage(chatId, "Menu");
            message1.setReplyMarkup(MarkupBoards.mainMenu());
            BOT.executeMessage(message1);
        } else if (message.getText().equals("/help") || message.getText().equals(Emojis.HELP + "Help")) {
            service.help(chatId);
        } else if (message.getText().equals("/support") || message.getText().equals(Emojis.SUPPORT + "Support")) {
            service.support(chatId);
        } else if (message.getText().equals("/feedback") || message.getText().equals(Emojis.FEEDBACK + "Feedback")) {
            service.feedback(chatId);
        }else if (message.getText().equals("/profile") || message.getText().equals(Emojis.PROFILE + "Profile")) {
            service.profile(chatId);
        } else if (message.getText().equals(Emojis.GO_BACK + "Back")) {
            service.mainMenu(chatId);
        }


    }
}
