package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.dto.auth.AuthUserCreateDto;
import com.example.pdp_meal.dto.auth.AuthUserDto;
import com.example.pdp_meal.enums.Role;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.repository.AuthUserRepository;
import com.example.pdp_meal.service.auth.AuthUserService;
import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.InlineBoards;
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

        if (Objects.nonNull(user)) {
            BOT.userState.put(chatId, State.START.getName());
        }

        if (message.hasContact() || (message.getText().equals("/start") && Objects.isNull(user)) ||
                !BOT.userState.get(chatId).equals(State.START.getName())) {
            registerService.register(message);
        } else if (message.getText().equals("/start") && Objects.nonNull(user)) {
            SendMessage message1 = new SendMessage(chatId, "Menu");

            message1.setReplyMarkup(MarkupBoards.mainMenu(user.getRole()));
            BOT.executeMessage(message1);
        } else if (message.getText().equals("/help") || message.getText().equals(Emojis.HELP + "Help")) {
            service.help(chatId);
        } else if (message.getText().equals("/support") || message.getText().equals(Emojis.SUPPORT + "Support")) {
            service.support(chatId);
        } else if (message.getText().equals("/feedback") || message.getText().equals(Emojis.FEEDBACK + "Feedback")) {
            service.feedback(chatId);
        } else if (message.getText().equals("/profile") || message.getText().equals(Emojis.PROFILE + "Profile")) {
            service.profile(chatId);
        } else if (message.getText().equals(Emojis.GO_BACK + "Back")) {
            service.mainMenu(chatId, user.getRole());
        }

    }




}
