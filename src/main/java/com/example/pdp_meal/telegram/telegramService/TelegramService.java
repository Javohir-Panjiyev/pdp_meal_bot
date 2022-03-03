package com.example.pdp_meal.telegram.telegramService;


import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.enums.Status;
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

@Service
@RequiredArgsConstructor
public class TelegramService {

    private final BotProcess BOT;


    public void register(Message message, State state) {
        String chatID = message.getChatId().toString();
        if (State.UNAUTHORIZED.equals(state) || Objects.isNull(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your full name please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
            UserState.put(chatID,State.USER_NAME);
        } else if (State.USER_NAME.equals(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your username please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
            UserState.put(chatID,State.PHONE_NUMBER);
            SendMessage phoneMessage = new SendMessage(chatID, Emojis.PHONE + "Share phone number please");
            phoneMessage.setReplyMarkup(MarkupBoards.sharePhoneNumber());
            BOT.executeMessage(phoneMessage);        } else if (State.PHONE_NUMBER.equals(state)) {
            String chatId = message.getChatId().toString();
            if (message.hasContact()) {
                SendMessage message1=new SendMessage(chatID, "Cho'tki");
                BOT.executeMessage(message1);
            } else {
                SendMessage sendMessage1 = new SendMessage(chatId, "Invalid Number format\nPlease send correct number");
                BOT.executeMessage(sendMessage1);
            }
        } else {
            DeleteMessage deleteMessage = new DeleteMessage(chatID, message.getMessageId());
            BOT.executeMessage(deleteMessage);
        }
    }


    public void getPhone(String chatId) {

    }

    public void getFullName(String chatId) {

    }

    public void getPassword(String chatId) {

    }

    public void ordering(String chatId) {

    }

    public void ordered(String chatId) {
    }

    public void preparing(String chatId) {

    }

    public void sendWrong(String chatId) {
        SendMessage msg = new SendMessage(chatId, "Wrong option");
        BOT.executeMessage(msg);
    }
}
