package com.example.pdp_meal.telegram.telegramService;


import com.example.pdp_meal.service.dailyMenu.DailyMenuService;
import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import com.example.pdp_meal.telegram.emojis.Emojis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class TelegramService {

    private final BotProcess BOT;
    private final DailyMenuService dailyMenuService;



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
        execute(chatId, "Wrong option");
    }

    public void help(String chatId) {
       String help = "\uD83E\uDD16  This bot will help \uD83C\uDD98 you to choose  and order a daily lunch \uD83E\uDD57 on weekdays . You can manipulate \uD83C\uDF9B the bot \uD83E\uDD16 with these commands.\n" +
                "\n" +
                "1.  /start - ✅ Start\n" +
                "2.  /feedback - ♻️ Feedback\n" +
                "3.  /support - \uD83D\uDCAC Support\n" +
                "4.  /profile - ℹ️ Profile \n" +
                "5.  /about_us - \uD83D\uDC65 About developer\n" +
                "6.  /help - \uD83C\uDD98 Help\n" +
                "\n" +
                "Contact Support if you encounter problems with the bot";

        execute(chatId, help);
    }

    private void execute(String chatId, String message) {
        SendMessage message1=new SendMessage(chatId, message);
        BOT.executeMessage(message1);
    }

    public void support(String chatId) {
       String help = "☹️ Having trouble with " +
               "the \uD83E\uDD16 bot? Contact \uD83D\uDCF2 Support" +
               " \uD83E\uDD1D . Support username: @PDPSupportBot";
        execute(chatId, help);
    }

    public void feedback(String chatId) {
        SendMessage message1 = new SendMessage(chatId, "Select the feedback type");
        message1.setReplyMarkup(MarkupBoards.feedBackMenu());
        BOT.executeMessage(message1);
    }

    public void mainMenu(String chatId) {
        SendMessage message1 = new SendMessage(chatId, Emojis.right +"Main menu" + Emojis.left);
        message1.setReplyMarkup(MarkupBoards.mainMenu());
        BOT.executeMessage(message1);
    }
}
