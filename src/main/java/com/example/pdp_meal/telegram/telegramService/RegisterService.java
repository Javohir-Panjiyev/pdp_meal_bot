package com.example.pdp_meal.telegram.telegramService;

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

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final BotProcess BOT;


    public void register(Message message, String state) {
        String chatID = message.getChatId().toString();

        if (State.UNAUTHORIZED.getName().equals(state) || Objects.isNull(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your full name please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
            //set qilinadi
            UserState.put(chatID, State.USER_NAME.getName());

        } else if (State.USER_NAME.getName().equals(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your username please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
            //set qilinadi
            UserState.put(chatID, State.PASSWORD.getName());
        } else if (State.PASSWORD.getName().equals(state)) {
            SendMessage sendMessage = new SendMessage(chatID, "Enter your password please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            BOT.executeMessage(sendMessage);
            ///set qilinadi
            UserState.put(chatID, State.PHONE_NUMBER.getName());
        } else if (State.PHONE_NUMBER.getName().equals(state)) {
            DeleteMessage deleteMessage = new DeleteMessage(chatID, message.getMessageId());
            BOT.executeMessage(deleteMessage);
            SendMessage phoneMessage = new SendMessage(chatID, Emojis.PHONE + "Your password has been accepted \nShare phone number please");
            phoneMessage.setReplyMarkup(MarkupBoards.sharePhoneNumber());
            BOT.executeMessage(phoneMessage);
            //set qilinadi
            UserState.put(chatID, State.REGISTERED.getName());
        } else if (State.REGISTERED.getName().equals(state)) {
            String chatId = message.getChatId().toString();
            if (message.hasContact()) {
                SendMessage message1 = new SendMessage(chatID, "Successfully authorized");
                message1.setReplyMarkup(MarkupBoards.done());
                BOT.executeMessage(message1);

            } else {
                SendMessage sendMessage1 = new SendMessage(chatId, "Invalid Number format\nPlease send correct number");
                BOT.executeMessage(sendMessage1);
            }
        }
    }

}
