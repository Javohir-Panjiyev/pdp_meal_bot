package com.example.pdp_meal.telegram.telegramService;

import com.example.pdp_meal.dto.auth.AuthUserCreateDto;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import com.example.pdp_meal.telegram.emojis.Emojis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;

import java.util.Objects;

import static com.example.pdp_meal.telegram.BotProcess.UserState;
import static com.example.pdp_meal.telegram.BotProcess.userHashMap;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final BotProcess BOT;


    public void register(Message message) {
        String chatID = message.getChatId().toString();
        String state = UserState.get(chatID);


        if (Objects.isNull(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your full name please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
//            AuthUserCreateDto userCreateDto = userHashMap.get(chatID);
//            userCreateDto.setFullName("56789");
//            userHashMap.put(chatID,userCreateDto);
            UserState.put(chatID, State.USER_NAME.getName());

        } else if (State.USER_NAME.getName().equals(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your username please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
//            AuthUserCreateDto userCreateDto = userHashMap.get(chatID);
//            userCreateDto.setUsername(message.getText());
//            userHashMap.put(chatID,userCreateDto);
            UserState.put(chatID, State.PASSWORD.getName());
        } else if (State.PASSWORD.getName().equals(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your password please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
//            AuthUserCreateDto userCreateDto = userHashMap.get(chatID);
//            userCreateDto.setPassword(message.getText());
//            userHashMap.put(chatID,userCreateDto);
            UserState.put(chatID, State.PHONE_NUMBER.getName());
        } else if (State.PHONE_NUMBER.getName().equals(state)) {
            DeleteMessage deleteMessage = new DeleteMessage(chatID, message.getMessageId());
            BOT.executeMessage(deleteMessage);
            SendMessage phoneMessage = new SendMessage();
            phoneMessage.setReplyMarkup(MarkupBoards.sharePhoneNumber());
            phoneMessage.setText("Share your phone Number");
            phoneMessage.setChatId(chatID);
            BOT.executeMessage(phoneMessage);
            UserState.put(chatID, State.REGISTERED.getName());
        } else if (UserState.get(chatID).equals(State.REGISTERED.getName())) {
            if (message.hasContact()) {
                SendMessage message1 = new SendMessage();
                message1.setChatId(chatID);
                message1.setText("Successfully registered");
                message1.setReplyMarkup(MarkupBoards.mainMenu());
                BOT.executeMessage(message1);

//            AuthUserCreateDto userCreateDto = userHashMap.get(chatId);
//            userCreateDto.setPhoneNumber(message.getContact()+"");
//            userHashMap.put(chatId, userCreateDto);

//            AuthUserCreateDto userDto = userHashMap.get(chatId);
//            userService.create(userDto);
                UserState.put(chatID, State.START.getName());
            }
        }
    }
}

