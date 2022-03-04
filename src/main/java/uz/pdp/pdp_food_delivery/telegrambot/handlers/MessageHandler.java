package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserService;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.InlineBoard;
import uz.pdp.pdp_food_delivery.telegrambot.config.Offset;
import uz.pdp.pdp_food_delivery.telegrambot.enums.AddMealState;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.*;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MessageHandler extends AbstractHandler {
    private final PdpFoodDeliveryBot bot;
    //    private final MenuProcessor menuProcessor;
    private final AuthUserRepository repository;
    private final AuthUserService service;
    private final AuthorizationProcessor authorizationProcessor;
    private final CallbackHandlerProcessor callbackHandlerProcessor;

    private final OrderMealProcessor orderMealProcessor;
    private final AddMealProcessor addMealProcessor;
    private final DailyMealProcessor dailyMealProcessor;
    private final Offset offset;
    private final MealService mealService;

    @Override
    public void handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Message message = update.getMessage();
        String text = message.getText();
        if (update.getMessage().hasText()) {
            if ("/order".equals(text)) {
                orderMealProcessor.process(message);
            } else if ("/photo".equals(text)) {
                addMealProcessor.process(message, State.getAddMealState(chatId));
                return;
            } else if ("/addmeal".equals(text)) {
                List<MealDto> meals = mealService.getAll();
                SendMessage sendMessage = new SendMessage(chatId, callbackHandlerProcessor.getMealMessage(meals, chatId).toString());
                sendMessage.setReplyMarkup(InlineBoard.meal(meals));
                bot.executeMessage(sendMessage);
            }

            boolean existChatId = repository.existsByChatId(chatId);
            boolean active = repository.isActive(chatId);
            String role = repository.getRole(chatId);
            if (!existChatId) {
                SendMessage sendMessage = new SendMessage();
                AuthUserCreateDto createDto = new AuthUserCreateDto(chatId);
                service.create(createDto);
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                authorizationProcessor.process(message, State.getState(chatId));
            }
            if (Objects.isNull(role)) {
                authorizationProcessor.process(message, State.getState(chatId));
            } else if (active) {
//                menuProcessor.menu(chatId,role);
            } else {
                //sabr kardam
            }
//            message.setChatId(update.getMessage().getChatId().toString());
//            message.setText(update.getMessage().getText());

            if ("/start".equals(text) && active) {
//                menuProcessor.menu(chatId, role);


                State.setMenuState(chatId, MenuState.UNDEFINED);
                if (Objects.isNull(role)) {
                    authorizationProcessor.process(message, State.getState(chatId));
                }
                if (Objects.nonNull(role) && State.getMenuState(chatId).equals(MenuState.UNDEFINED)) {
//                    menuProcessor.menu(chatId, role);
                }
                return;
            }
        }


        if (State.getAddMealState(chatId) == AddMealState.FILE) {
            addMealProcessor.process(message, State.getAddMealState(chatId));
        }
    }
}
