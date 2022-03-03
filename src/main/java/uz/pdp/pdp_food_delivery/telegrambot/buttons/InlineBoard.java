package uz.pdp.pdp_food_delivery.telegrambot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.telegrambot.emoji.Emoji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InlineBoard {
    public static InlineKeyboardMarkup meal(ArrayList<MealDto> meals, Integer limit, Integer offset) {
        InlineKeyboardMarkup board = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> numberButtons = new ArrayList<>();
        List<InlineKeyboardButton> numberButtons1 = new ArrayList<>();
        List<String> numbers = new ArrayList<>(Arrays.asList("1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣", "\uD83D\uDD1F"));
        int i = 1;
        if (meals.size() <= 5) {
            for (MealDto meal : meals) {
                InlineKeyboardButton button = new InlineKeyboardButton(numbers.get(i++ - 1));
//                String id = mealRepository.getId(meal.getPicture());
//                button.setCallbackData(id);
                numberButtons.add(button);
            }
            buttons.add(numberButtons);
        } else {
            for (int j = 0; j < meals.size(); j++) {
                if (j >= meals.size() / 2) {
                    InlineKeyboardButton button = new InlineKeyboardButton(numbers.get(i++ - 1));
//                    String id = mealRepository.getId(meals.get(j).getId());
//                    button.setCallbackData(id);
                    numberButtons1.add(button);
                } else {
                    InlineKeyboardButton button = new InlineKeyboardButton(numbers.get(i++ - 1));
//                    String id = mealRepository.getId(meals.get(j).getId());
//                    button.setCallbackData(id);
                    numberButtons.add(button);
                }
            }
            buttons.add(numberButtons);
            buttons.add(numberButtons1);
        }

        List<InlineKeyboardButton> extraButtons = new ArrayList<>();
        if (offset > 0) {
            InlineKeyboardButton prevButton = new InlineKeyboardButton(Emoji.PREVIOUS);
            prevButton.setCallbackData("prev");
            extraButtons.add(prevButton);
        }
        InlineKeyboardButton cancelButton = new InlineKeyboardButton(Emoji.REMOVE);
        cancelButton.setCallbackData("cancel");
        extraButtons.add(cancelButton);
        if (meals.size() == limit) {
            InlineKeyboardButton nextButton = new InlineKeyboardButton(Emoji.NEXT);
            nextButton.setCallbackData("next");
            extraButtons.add(nextButton);
        }
        buttons.add(extraButtons);
        board.setKeyboard(buttons);
        return board;
    }
}
