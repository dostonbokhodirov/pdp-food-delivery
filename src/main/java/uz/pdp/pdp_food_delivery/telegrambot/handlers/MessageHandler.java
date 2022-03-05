package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.telegrambot.enums.AddMealState;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AddMealProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AuthorizationProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.DailyMealProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.processors.OrderMealProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

@Component
@RequiredArgsConstructor
public class MessageHandler extends AbstractHandler {
    private final AuthUserRepository repository;
    private final AuthorizationProcessor processor;

    private final OrderMealProcessor orderMealProcessor;
    private final AddMealProcessor addMealProcessor;
    private final DailyMealProcessor dailyMealProcessor;

    @Override
    public void handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Message message = update.getMessage();
        String text = message.getText();
        boolean existChatId = repository.existsByChatId(chatId);

        if ("/addmeal".equals(text)) {
            addMealProcessor.process(message, State.getAddMealState(chatId));
            return;
        }
        if ("/order".equals(text)) {
            orderMealProcessor.process(message);
            return;
        }
        if ("/daily".equals(text)) {
            dailyMealProcessor.process(message);
        }

//        if ("/start".equals(text) && !existChatId) {
//            AuthUser user = new AuthUser();
//            user.setChatId(chatId);
//            repository.save(user);
//            State.setState(chatId, UState.ANONYMOUS);
//        }
//        processor.process(message);

        if (State.getAddMealState(chatId).equals(AddMealState.FILE)) {
            addMealProcessor.process(message, State.getAddMealState(chatId));
        }
    }
}
