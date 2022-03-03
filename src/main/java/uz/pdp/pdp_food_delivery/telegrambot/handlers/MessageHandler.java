package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserService;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.emojis.Emojis;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AuthorizationProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.MenuProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MessageHandler extends AbstractHandler {
    private final PdpFoodDeliveryBot bot;
    private final MenuProcessor menuProcessor;
    private final AuthUserRepository repository;
    private final AuthUserService service;
    private final AuthorizationProcessor authorizationProcessor;

    @Override
    public void handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Message message = update.getMessage();
        String text = message.getText();
        if ( update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();

            boolean existChatId = repository.existsByChatId(chatId);
            boolean active = repository.isActive(chatId);
            String role = repository.getRole(chatId);
            if (!existChatId) {
                AuthUserCreateDto createDto = new AuthUserCreateDto(chatId);
                service.create(createDto);
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                authorizationProcessor.process(message, State.getState(chatId));
            }
            if (Objects.isNull(role)) {
                authorizationProcessor.process(message, State.getState(chatId));
            } else if (active) {
                menuProcessor.menu(chatId,role);
            } else {
                //sabr kardam
            }
//            message.setChatId(update.getMessage().getChatId().toString());
//            message.setText(update.getMessage().getText());

            if ("/start".equals(text) && active) {
                menuProcessor.menu(chatId, role);



                State.setMenuState(chatId, MenuState.UNDEFINED);
                if (Objects.isNull(role)) {
                    authorizationProcessor.process(message, State.getState(chatId));
                }
                if (Objects.nonNull(role) && State.getMenuState(chatId).equals(MenuState.UNDEFINED)) {
                    menuProcessor.menu(chatId, role);
                }
                return;
            }
            bot.executeMessage(sendMessage);
        }
    }
}
