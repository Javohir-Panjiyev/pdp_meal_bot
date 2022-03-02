package com.example.pdp_meal.telegram.handlers;


import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateHandler {

    private final MessageHandler messageHandler;
    private final CallbackHandler callbackHandler = CallbackHandler.getInstance();

    public UpdateHandler(MessageHandler messageHandle) {
        this.messageHandler = messageHandle;
    }

    public void handle(Update update) {
        if (update.hasMessage()) {
            messageHandler.handle(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            callbackHandler.handle(update.getCallbackQuery());
        } else System.out.println("Not Found");
    }

}
