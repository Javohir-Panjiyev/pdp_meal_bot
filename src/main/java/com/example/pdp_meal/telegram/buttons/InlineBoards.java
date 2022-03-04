package com.example.pdp_meal.telegram.buttons;

import com.example.pdp_meal.telegram.emojis.Emojis;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.List;

public class InlineBoards {

    private static final InlineKeyboardMarkup board = new InlineKeyboardMarkup();

    public static ReplyKeyboard department() {

        InlineKeyboardButton academic = new InlineKeyboardButton(Emojis.ACADEMIC +"Academic" );
        academic.setCallbackData("academic");

        InlineKeyboardButton marketing = new InlineKeyboardButton(Emojis.MARKETING +"Marketing" );
        marketing.setCallbackData("marketing");

        InlineKeyboardButton economic = new InlineKeyboardButton(Emojis.ECONOMIC + "Economic");
        economic.setCallbackData("economic");

        board.setKeyboard(Arrays.asList(getRow(academic), getRow(marketing), getRow(economic)));
        return board;
    }

    private static List<InlineKeyboardButton> getRow(InlineKeyboardButton... buttons) {
        return Arrays.stream(buttons).toList();
    }

    public static ReplyKeyboard position() {
        InlineKeyboardButton teacher = new InlineKeyboardButton(Emojis.ACADEMIC +"Teacher" );
        teacher.setCallbackData("teacher");

        InlineKeyboardButton administrator = new InlineKeyboardButton(Emojis.MARKETING +"Administrator" );
        administrator.setCallbackData("administrator");

        InlineKeyboardButton employee = new InlineKeyboardButton(Emojis.ECONOMIC + "Employee");
        employee.setCallbackData("employee");

        InlineKeyboardButton headDepartment = new InlineKeyboardButton(Emojis.ECONOMIC + "Head Department");
        headDepartment.setCallbackData("headDepartment");

        board.setKeyboard(Arrays.asList(getRow(teacher), getRow(administrator), getRow(employee), getRow(headDepartment)));
        return board;
    }
}
