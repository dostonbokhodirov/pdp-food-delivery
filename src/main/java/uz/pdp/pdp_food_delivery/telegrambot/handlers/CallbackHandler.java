package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;

@Component
public class CallbackHandler extends AbstractHandler {
    @Override
    public void handle(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();

    }
}
