package uz.pdp.pdp_food_delivery.telegrambot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.emoji.Emoji;

import java.util.List;

public class MarkupBoard {
    private static final ReplyKeyboardMarkup board = new ReplyKeyboardMarkup();

    public static ReplyKeyboardMarkup userMenu(String chatId) {
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton(Emoji.HISTORY + " " + LangConfig.get(chatId, "order.history")));
        row.add(new KeyboardButton(Emoji.SETTINGS + " " + LangConfig.get(chatId, "settings")));

        board.setKeyboard(List.of(row));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }
}
