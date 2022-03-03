package uz.pdp.pdp_food_delivery.telegrambot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserServiceIml;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.UpdateHandler;

import java.util.Objects;

@Component
public class PdpFoodDeliveryBot extends TelegramLongPollingBot {

    private final AuthUserServiceIml authUserService;
    private final UpdateHandler updateHandler;

    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    public PdpFoodDeliveryBot(AuthUserServiceIml authUserService, @Lazy UpdateHandler updateHandler) {
        this.authUserService = authUserService;
        this.updateHandler = updateHandler;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() &&
                Objects.nonNull(update.getMessage().getText()) && update.getMessage().getText().equals("/start")) {
            authUserService.save(update.getMessage());
        }
        updateHandler.handle(update);
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    public void executeMessage(BotApiMethod<?> msg) {
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeMessage(SendMessage msg) {
        msg.setParseMode("HTML");
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeMessage(SendDocument msg) {
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeMessage(EditMessageText msg) {
        msg.setParseMode("HTML");
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
