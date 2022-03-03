package uz.pdp.pdp_food_delivery.telegrambot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
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

    public static ReplyKeyboardMarkup department(String chatId) {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("ACADEMIC"));
        row1.add(new KeyboardButton("SALES"));
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("HR"));
        row2.add(new KeyboardButton("SERVICE"));
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("MARKETING"));
        row3.add(new KeyboardButton("MENTORS"));
        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("ECMA"));
        row4.add(new KeyboardButton("ACCOUNTING"));
        KeyboardRow row5 =new KeyboardRow();
        row5.add(new KeyboardButton("UNICORN"));
        row5.add("HEAD");
        board.setKeyboard(List.of(row1,row2,row3,row4,row5));
        board.setResizeKeyboard(true);
        board.setSelective(true);
        return board;
    }

}
