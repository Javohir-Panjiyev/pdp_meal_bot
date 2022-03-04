package com.example.pdp_meal.telegram.handlers;


import com.example.pdp_meal.dto.auth.AuthUserCreateDto;
import com.example.pdp_meal.enums.Role;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.service.auth.AuthUserService;
import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.InlineBoards;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class CallbackHandler {
    private final BotProcess BOT;
    private final AuthUserService userService;


    public void handle(CallbackQuery callbackQuery) {
        Message message = callbackQuery.getMessage();
        String data = callbackQuery.getData();
        String chatID = message.getChatId().toString();
        switch (data) {
            case "academic", "marketing", "economic" -> {
                DeleteMessage deleteMessage = new DeleteMessage(chatID, message.getMessageId());
                BOT.executeMessage(deleteMessage);
                AuthUserCreateDto userCreateDto = BOT.userHashMap.get(chatID);
                userCreateDto.setDepartment(data);
                BOT.userHashMap.put(chatID, userCreateDto);
                SendMessage message1 = new SendMessage(chatID, "Choose your position");
                message1.setReplyMarkup(InlineBoards.position());
                BOT.executeMessage(message1);
                BOT.userState.put(chatID, State.POSITION.getName());
            }

            case "teacher", "administrator", "headDepartment" -> {
                DeleteMessage deleteMessage = new DeleteMessage(chatID, message.getMessageId());
                BOT.executeMessage(deleteMessage);
                AuthUserCreateDto userCreateDto = BOT.userHashMap.get(chatID);
                userCreateDto.setChatId(chatID);
                userCreateDto.setState(State.REGISTERED.getName());
                userCreateDto.setRole(Role.USER.name());
                userCreateDto.setPosition(data);
                userCreateDto.setActive(true);
                userCreateDto.setState(State.REGISTERED.getName());
                BOT.userHashMap.put(chatID, userCreateDto);
                userService.create(userCreateDto);
                BOT.userState.put(chatID, State.REGISTERED.getName());
                SendMessage message1 = new SendMessage(chatID, "Successfully registered");
                message1.setReplyMarkup(MarkupBoards.mainMenu());
                BOT.executeMessage(message1);
            }


        }

    }

}
