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
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(Emoji.ADD_BOOK + " " + LangConfig.get(chatId, "add.book")));
        row1.add(new KeyboardButton(Emoji.DOWNLOAD + " " + LangConfig.get(chatId, "downloaded.books")));

        board.setKeyboard(List.of(row1));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }
}
