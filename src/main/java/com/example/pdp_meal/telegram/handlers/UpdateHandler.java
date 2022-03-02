package com.example.pdp_meal.telegram.handlers;



import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateHandler {

    private static UpdateHandler instance = new UpdateHandler();


    private final MessageHandler messageHandler = MessageHandler.getInstance();
    private final CallbackHandler callbackHandler = CallbackHandler.getInstance();

    public void handle(Update update) {
        if (update.hasMessage()){
            messageHandler.handle(update.getMessage());
        }
        else if (update.hasCallbackQuery()) {
            callbackHandler.handle(update.getCallbackQuery());
        }
        else System.out.println("Not Found");
    }
    public static UpdateHandler getInstance() {
        return instance;
    }
}
