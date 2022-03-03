package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.emojis.Emojis;
import uz.pdp.pdp_food_delivery.telegrambot.enums.SettingsState;
import uz.pdp.pdp_food_delivery.telegrambot.enums.UState;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AuthorizationProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.SettingProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.Objects;

import static uz.pdp.pdp_food_delivery.telegrambot.states.State.setState;

@Component
public class CallbackHandler extends AbstractHandler {


    private final AuthUserRepository authUserRepository;
    private final AuthorizationProcessor authorizationProcessor;
    private final SettingProcessor settingProcessor;
    private final PdpFoodDeliveryBot bot;

    public CallbackHandler(AuthUserRepository authUserRepository, AuthorizationProcessor authorizationProcessor, SettingProcessor settingProcessor, PdpFoodDeliveryBot bot) {
        this.authUserRepository = authUserRepository;
        this.authorizationProcessor = authorizationProcessor;
        this.settingProcessor = settingProcessor;
        this.bot = bot;
    }

    @Override
    public void handle(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        Message message = callbackQuery.getMessage();
        String data = callbackQuery.getData();
        String chatId = message.getChatId().toString();
        if ("uz".equals(data) || "ru".equals(data) || "en".equals(data)) {
            authUserRepository.updateLanguage(chatId, data);
            SendMessage sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "enter.full.name"));
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            bot.executeMessage(sendMessage);
            setState(chatId, UState.FULL_NAME);
            authorizationProcessor.process(message, State.getState(chatId));
            deleteMessage(message, chatId);
        }

    }

    public void languageMessage(Message message, String data) {
        String chatId = message.getChatId().toString();
        String role = authUserRepository.getRole(chatId);
        if (Objects.isNull(role)) {
            authUserRepository.updateLanguage(chatId, message.getText());


        } else {
            authUserRepository.updateLanguage(chatId, message.getText());
            SendMessage sendMessage = new SendMessage(chatId, Emojis.ADD + " " +
                    LangConfig.get(chatId, "language.changed"));
            bot.executeMessage(sendMessage);
            State.setSettingsState(chatId, SettingsState.UNDEFINED);
            settingProcessor.menu(chatId, LangConfig.get(chatId, "settings.menu"));
        }
    }

    private void deleteMessage(Message message, String chatId) {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
        bot.executeMessage(deleteMessage);
    }
}
