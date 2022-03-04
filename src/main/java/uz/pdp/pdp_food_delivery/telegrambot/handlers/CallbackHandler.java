package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.enums.Role;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.MarkupBoard;
import uz.pdp.pdp_food_delivery.telegrambot.emojis.Emojis;
import uz.pdp.pdp_food_delivery.telegrambot.enums.Language;
import uz.pdp.pdp_food_delivery.telegrambot.enums.SettingsState;
import uz.pdp.pdp_food_delivery.telegrambot.enums.UState;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.config.Offset;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.enums.SearchState;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.CallbackHandlerProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.DailyMealProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AuthorizationProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.SettingProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

import java.util.Objects;

import static uz.pdp.pdp_food_delivery.telegrambot.states.State.setState;

@Component
@RequiredArgsConstructor
public class CallbackHandler extends AbstractHandler {


    private final AuthUserRepository authUserRepository;
    private final AuthorizationProcessor authorizationProcessor;
    private final SettingProcessor settingProcessor;
    private final PdpFoodDeliveryBot bot;

//    public CallbackHandler(AuthUserRepository authUserRepository, AuthorizationProcessor authorizationProcessor, SettingProcessor settingProcessor, PdpFoodDeliveryBot bot) {
//        this.authUserRepository = authUserRepository;
//        this.authorizationProcessor = authorizationProcessor;
//        this.settingProcessor = settingProcessor;
//        this.bot = bot;
//    }


    private final MealService mealService;
    //    private final DailyMealService dailyMealService;
    private final DailyMealProcessor dailyMealProcessor;
    private final Offset offset;
    private final CallbackHandlerProcessor callbackHandlerProcessor;

    @Override
    public void handle(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
//        Message message = update.getMessage();
//        String chatId = message.getChatId().toString();
//        String data = callbackQuery.getData();

        Message message = callbackQuery.getMessage();
        String data = callbackQuery.getData();
        String chatId = message.getChatId().toString();
        if ("uz".equals(data) || "ru".equals(data) || "en".equals(data)) {
            AuthUser user = authUserRepository.getByChatId(chatId);
            user.setLanguage(Language.getByCode(data));
            authUserRepository.save(user);
            SendMessage sendMessage = new SendMessage(chatId,"Enter your Fullname: ");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            setState(chatId, UState.FULL_NAME);
            deleteMessage(message, chatId);
            bot.executeMessage(sendMessage);
        }else if(data.startsWith("accept_")){
            String acceptedUser = data.substring(7);
            if (data.substring(7).equals("no")){
                SendMessage sendMessage = new SendMessage(chatId, "User not Accepted");
                DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
                bot.executeMessage(deleteMessage);
                bot.executeMessage(sendMessage);
            }else {
                AuthUser user = authUserRepository.getByChatId(acceptedUser);
                user.setRole(Role.USER);
                State.setState(acceptedUser, UState.AUTHORIZED);
                State.setMenuState(acceptedUser, MenuState.UNDEFINED);
                authUserRepository.save(user);
                DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
                bot.executeMessage(deleteMessage);
                SendMessage sendMessage= new SendMessage(chatId, "User successfully added!");
                bot.executeMessage(sendMessage);
                SendMessage sendMessage1 = new SendMessage(acceptedUser, "You are successfully registered");
                sendMessage1.setReplyMarkup(MarkupBoard.menuUser());
                bot.executeMessage(sendMessage1);

            }
        }else if (data.equals("prev")) {
            offset.setSearchOffset(chatId, -1);
            callbackHandlerProcessor.prevMessage(message, offset.getSearchOffset(chatId));
        } else if (data.equals("next")) {
            offset.setSearchOffset(chatId, 1);
            callbackHandlerProcessor.nextMessage(message, offset.getSearchOffset(chatId));
        } else if (data.equals("cancel")) {
            offset.setSearchOffset(chatId, 0);
            deleteMessage(message, chatId);
            State.setMenuState(chatId, MenuState.UNDEFINED);
            State.setSearchState(chatId, SearchState.UNDEFINED);
        } else {
            MealDto mealDto = mealService.get(Long.valueOf(data));
            SendMessage sendMessage = new SendMessage(chatId, mealDto.getName());
            bot.executeMessage(sendMessage);
        }



    }

    private void deleteMessage(Message message, String chatId) {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
        bot.executeMessage(deleteMessage);
    }
}
