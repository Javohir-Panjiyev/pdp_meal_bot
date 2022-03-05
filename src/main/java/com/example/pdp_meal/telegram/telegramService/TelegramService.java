package com.example.pdp_meal.telegram.telegramService;


import com.example.pdp_meal.dto.dailyMenu.DailyMenuCreateDto;
import com.example.pdp_meal.dto.dailyMenu.DailyMenuDto;
import com.example.pdp_meal.dto.meal.MealDto;
import com.example.pdp_meal.dto.order.OrderCreateDto;
import com.example.pdp_meal.entity.AuthUser;
import com.example.pdp_meal.entity.MealOrder;
import com.example.pdp_meal.enums.State;
import com.example.pdp_meal.repository.AuthUserRepository;
import com.example.pdp_meal.service.dailyMenu.DailyMenuService;
import com.example.pdp_meal.service.meal.MealService;
import com.example.pdp_meal.service.order.OrderService;
import com.example.pdp_meal.telegram.BotProcess;
import com.example.pdp_meal.telegram.buttons.InlineBoards;
import com.example.pdp_meal.telegram.buttons.MarkupBoards;
import com.example.pdp_meal.telegram.emojis.Emojis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import java.util.List;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class TelegramService {

    private final BotProcess BOT;
    private final AuthUserRepository userRepository;
    private final DailyMenuService dailyMenuService;
    private final MealService mealService;
    private final OrderService orderService;



    public void getPhone(String chatId) {

    }

    public void changeStatus(String chatId,String state){
        userRepository.changeStatus(chatId,state);
    }

    public void getFullName(String chatId) {

    }

    public void getPassword(String chatId) {

    }

    public void ordering(String chatId) {
        AuthUser byChatId = userRepository.findByChatId(chatId);
        if(byChatId.getState().equals(State.ORDERING.getName())) BOT.executeMessage(getMenu(chatId));
        AuthUser user = userRepository.findByChatId(chatId);
        user.setState(State.REGISTERED.getName());
        userRepository.save(user);
    }

    private SendMessage getMenu(String chatId) {
        List<DailyMenuDto> all = dailyMenuService.getAll();
        ReplyKeyboard menu = InlineBoards.menu(all);
        String menuString = getMenuString(all);
        SendMessage msg = new SendMessage(chatId, menuString);
        msg.setReplyMarkup(menu);
        return msg;
    }

    private String getMenuString(List<DailyMenuDto> all) {
        StringBuilder menus = new StringBuilder();
        menus.append("Today's menu.\n" +
                "Please select the appropriate number of meals \n\n");

        int counter = 1;
        if(all.isEmpty()){
            return "Meals Not Found \nContact with your Admin";
        }
        for (DailyMenuDto dailyMenuDto : all) {
            MealDto mealDto = mealService.get(dailyMenuDto.getMealId());
            menus.append(counter).append(". ").append(mealDto.getName()).append("\n");
            counter++;
        }
        return menus.toString();
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

    public void mainMenu(String chatId, String role) {
        SendMessage message1 = new SendMessage(chatId, Emojis.right +"Main menu" + Emojis.left);
        message1.setReplyMarkup(MarkupBoards.mainMenu(role));
        BOT.executeMessage(message1);
    }

    public void profile(String chatId) {
        AuthUser user = userRepository.findByChatId(chatId);
        SendMessage profileMessage = new SendMessage();
        profileMessage.setChatId(chatId);
        profileMessage.setText("\nProfile Data \uD83D\uDC47" +
                "\nFull name      : " + user.getFullName() +
                "\nUser name      : " + user.getUsername() +
                "\nPhone          : " + user.getPhone() +
                "\nDepartment     : " + user.getDepartment() +
                "\nPosition       : " + user.getPosition()
        );
        BOT.executeMessage(profileMessage);
    }

    public void orderMeal(String chatID, String data) {
        OrderCreateDto order = new OrderCreateDto();
        order.setMealId(Integer.parseInt(data));
        order.setUserId(userRepository.findByChatId(chatID).getId());
        orderService.create(order);
        sendAcceptedMesssage(chatID);
    }

    private void sendAcceptedMesssage(String chatID) {
        SendMessage msg = new SendMessage(chatID, "Your Order is Accepted");
        BOT.executeMessage(msg);
    }
}
