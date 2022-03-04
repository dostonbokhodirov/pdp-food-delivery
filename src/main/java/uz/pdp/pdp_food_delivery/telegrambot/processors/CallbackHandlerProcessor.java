package uz.pdp.pdp_food_delivery.telegrambot.processors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.InlineBoard;
import uz.pdp.pdp_food_delivery.telegrambot.config.TargetMeal;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CallbackHandlerProcessor {

    public StringBuilder getMealMessage(List<MealDto> meals, String chatId) {
        StringBuilder messageText = new StringBuilder();
        int i = 1;
        if (meals.size() == 0) {
            messageText.append(LangConfig.get(chatId, "no.meal"));
        } else {
            for (MealDto meal : meals) {
                if (meal.getId().equals(TargetMeal.getTargetMeal(chatId).getId())) {
                    messageText.append("<code>");
                    getMessage(messageText, meal);
                    messageText.append("</code>");
                } else {
                    getMessage(messageText, meal);
                }
            }
        }
//        else {
//            for (MealDto meal : meals) {
//                messageText.append("<code>")
//                        .append(i++).append(".</code> ")
//                        .append(LangConfig.get(chatId, "meal.name"))
//                        .append(" <b>").append(meal.getName()).append("</b>\n");
//            }
//        }
        return messageText;
    }

    private StringBuilder getMessage(StringBuilder stringBuilder, MealDto meal) {
        stringBuilder.append("Meal: ").append(meal.getName());
        return stringBuilder;
    }

    public void nextMessage(Message message, Integer offset) {
//        String chatId = message.getChatId().toString();
//        ArrayList<MealDto> meals;
//        EditMessageText editMessageText = new EditMessageText();
//        editMessageText.setChatId(chatId);
//        editMessageText.setMessageId(message.getMessageId());
//        if (State.getMenuState(chatId).equals(MenuState.SEARCH)) {
//            meals = bookRepository.getBooksByName(msg.getSearchMessage(chatId), State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.UPLOADED)) {
//            meals = bookRepository.getUploadedBooks(chatId, State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.TOP)) {
//            meals = bookRepository.getTopBooks(State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.DOWNLOADED)) {
//            meals = bookRepository.getDownloadedBooks(chatId, State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.USERLIST)) {
//            ArrayList<User> users = authUserRepository.getUsers(State.getLimitState(chatId), offset);
//            editMessageText.setText(getUserMessage(users, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.user(users, offset));
//            BOT.executeMessage(editMessageText);
//        }
    }

    public void prevMessage(Message message, Integer offset) {
//        String chatId = message.getChatId().toString();
//        ArrayList<Book> meals;
//        EditMessageText editMessageText = new EditMessageText();
//        editMessageText.setChatId(chatId);
//        editMessageText.setMessageId(message.getMessageId());
//        if (State.getMenuState(chatId).equals(MenuState.SEARCH)) {
//            meals = bookRepository.getBooksByName(msg.getSearchMessage(chatId), State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.TOP)) {
//            meals = bookRepository.getTopBooks(State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.UPLOADED)) {
//            meals = bookRepository.getUploadedBooks(chatId, State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.DOWNLOADED)) {
//            meals = bookRepository.getDownloadedBooks(chatId, State.getLimitState(chatId), offset);
//            editMessageText.setText(getBookMessage(meals, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.book(meals, State.getLimitState(chatId), offset));
//            BOT.executeMessage(editMessageText);
//        } else if (State.getMenuState(chatId).equals(MenuState.USERLIST)) {
//            ArrayList<User> users = authUserRepository.getUsers(State.getLimitState(chatId), offset);
//            editMessageText.setText(getUserMessage(users, chatId).toString());
//            editMessageText.setReplyMarkup(InlineBoard.user(users, offset));
//            BOT.executeMessage(editMessageText);
//        }
    }
}
