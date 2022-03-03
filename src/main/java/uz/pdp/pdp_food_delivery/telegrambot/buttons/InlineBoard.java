package uz.pdp.pdp_food_delivery.telegrambot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.pdp_food_delivery.telegrambot.emojis.Emojis;

import java.util.Arrays;
import java.util.List;

public class InlineBoard {

    private static final InlineKeyboardMarkup board = new InlineKeyboardMarkup();


    public static InlineKeyboardMarkup languageButtons() {
        InlineKeyboardButton uz = new InlineKeyboardButton(Emojis.UZ + " O'zbek");
        uz.setCallbackData("uz");

        InlineKeyboardButton ru = new InlineKeyboardButton(Emojis.RU + " Русский");
        ru.setCallbackData("ru");

        InlineKeyboardButton en = new InlineKeyboardButton(Emojis.EN + " English");
        en.setCallbackData("en");
        board.setKeyboard(Arrays.asList(getRow(uz), getRow(ru), getRow(en)));
        return board;
    }


    private static List<InlineKeyboardButton> getRow(InlineKeyboardButton... buttons) {
        return Arrays.stream(buttons).toList();
    }
}
