package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserService;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.MarkupBoard;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AuthorizationProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.OrderMealProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MessageHandler extends AbstractHandler {
    private final PdpFoodDeliveryBot bot;
    private final AuthorizationProcessor authorizationProcessor;
    private final OrderMealProcessor orderMealProcessor;
    //    private final MenuProcessor menuProcessor;
    private final AuthUserService authUserService;


    @Override
    public void handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Message message = update.getMessage();
        String command = update.getMessage().getText();
        String role = authUserService.findRoleByChatId(chatId);


        if ("/start".equals(command) || Objects.isNull(role)) {
            State.setMenuState(chatId, MenuState.UNDEFINED);
            ReplyKeyboardMarkup replyKeyboardMarkup = MarkupBoard.userMenu(chatId);
            SendMessage sendMessage = new SendMessage(chatId, "<b>" + LangConfig.get(chatId, "choose.menu") + "</b>");
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
//            if (Objects.isNull(role)) {
//                authorizationProcessor.process(message, State.getState(chatId));
//            }
//            if (Objects.nonNull(role) && State.getMenuState(chatId).equals(MenuState.UNDEFINED)) {
//                menuProcessor.menu(chatId, role);
//            }
            return;
        } else if ("/order".equals(command)) {
            State.setMenuState(chatId, MenuState.ORDER);
            orderMealProcessor.process(message);
        }
    }
}
