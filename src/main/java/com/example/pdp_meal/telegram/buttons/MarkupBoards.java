package com.example.pdp_meal.telegram.buttons;

import com.example.pdp_meal.telegram.emojis.Emojis;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@Component
public class MarkupBoards {

    private static final ReplyKeyboardMarkup board = new ReplyKeyboardMarkup();


    public static ReplyKeyboardMarkup sharePhoneNumber() {
        KeyboardButton phoneContact = new KeyboardButton(Emojis.PHONE + "Share phone number please ");
        phoneContact.setRequestContact(true);
        board.setResizeKeyboard(true);
        board.setSelective(true);
        KeyboardRow row = new KeyboardRow();
        row.add(phoneContact);
        board.setKeyboard(List.of(row));
        return board;

    }

}
