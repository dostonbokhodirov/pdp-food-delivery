package uz.pdp.pdp_food_delivery.telegrambot.processors;

import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;

import java.util.List;

public class CallbackHandlerProcessor {
    public StringBuilder getMealMessage(List<MealDto> meals, String chatId) {
        StringBuilder messageText = new StringBuilder();
        int i = 1;
        if (meals.size() == 0) {
            messageText.append(LangConfig.get(chatId, "no.meal"));
        } else {
            for (MealDto meal : meals) {
                messageText.append("<code>")
                        .append(i++).append(".</code> ")
                        .append(LangConfig.get(chatId, "meal.name"))
                        .append(" <b>").append(meal.getName()).append("</b>\n");
            }
        }
        return messageText;
    }
}
