package uz.pdp.pdp_food_delivery.telegrambot.processors;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.InlineBoard;
import uz.pdp.pdp_food_delivery.telegrambot.config.Offset;
import uz.pdp.pdp_food_delivery.telegrambot.config.OffsetBasedPageRequest;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.enums.SearchState;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OrderMealProcessor {

    private final PdpFoodDeliveryBot bot;
    private final CallbackHandlerProcessor callbackHandlerProcessor;
    private final MealService mealService;
    private final Offset offset;

    public void process(Message message) {
        String chatId = message.getChatId().toString();
        Pageable pageable = new OffsetBasedPageRequest(offset.getSearchOffset(chatId), State.getLimitState(chatId));
        List<MealDto> meals = mealService.getAllByLimit(pageable);
        SendMessage sendMessage;
        if (meals.size() == 0) {
            sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "no.meal"));
            State.setSearchState(chatId, SearchState.UNDEFINED);
            State.setMenuState(chatId, MenuState.UNDEFINED);
        } else {
            offset.setSearchOffset(chatId, 0);
            sendMessage = new SendMessage(chatId, callbackHandlerProcessor.getMealMessage(meals, chatId).toString());
            sendMessage.setReplyMarkup(InlineBoard.meal(meals, State.getLimitState(chatId), offset.getSearchOffset(chatId)));
        }
        bot.executeMessage(sendMessage);
    }
}
