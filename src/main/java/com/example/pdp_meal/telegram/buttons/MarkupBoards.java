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

    public static ReplyKeyboardMarkup mainMenu() {
        //row1
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(Emojis.FEEDBACK+"Feedback"));
        //row2
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton(Emojis.ABOUT_US+"About us"));
        row2.add(new KeyboardButton(Emojis.PROFILE+"Profile"));

        //row2
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton(Emojis.HELP+"Help"));
        row3.add(new KeyboardButton(Emojis.SUPPORT+"Support"));

        //row3

        board.setKeyboard(List.of(row1, row2, row3));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

    public static ReplyKeyboardMarkup feedBackMenu(){
        //row1
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(Emojis.OFFER+"Offer"));
        row1.add(new KeyboardButton(Emojis.DISAPPROVAL+"Disapproval"));
        //row2
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton(Emojis.GO_BACK+"Back"));

        board.setKeyboard(List.of(row1, row2));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }
    public static ReplyKeyboardMarkup done(){
        //row1
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(Emojis.OK+"Done"));
        board.setKeyboard(List.of(row1));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

}
