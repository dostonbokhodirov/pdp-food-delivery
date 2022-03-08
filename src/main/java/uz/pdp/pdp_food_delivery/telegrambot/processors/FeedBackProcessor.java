package uz.pdp.pdp_food_delivery.telegrambot.processors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.service.auth.AuthUserService;
import uz.pdp.pdp_food_delivery.rest.service.feedback.FeedbackService;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.MarkupBoard;
import uz.pdp.pdp_food_delivery.telegrambot.emojis.Emojis;
import uz.pdp.pdp_food_delivery.telegrambot.enums.FeedbackState;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

@Component
@RequiredArgsConstructor
public class FeedBackProcessor {

    private final PdpFoodDeliveryBot bot;
    private final FeedbackService feedbackService;
    private final AuthUserService authUserService;


    public void process(Message message) {
        String chatId = message.getChatId().toString();
        if (State.getFeedbackState(chatId).equals(FeedbackState.UNDEFINED)) {
//            SendMessage sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "upload.photo"));
            SendMessage sendMessage = new SendMessage(chatId, "Send feedback");
            bot.executeMessage(sendMessage);
            State.setFeedbackState(chatId, FeedbackState.SENT);
        } else if (State.getFeedbackState(chatId).equals(FeedbackState.SENT)) {
            if (message.hasText()) {
                AuthUserDto userDto = authUserService.getByChatId(chatId);
                feedbackService.create(new FeedbackCreateDto(message.getText(), userDto.getId()));
//                SendMessage sendMessage = new SendMessage(chatId,
//                        Emojis.ADD + " " + LangConfig.get(chatId, "photo.uploaded"));
                SendMessage sendMessage = new SendMessage(chatId,
                        "Choose type");
//                sendMessage.setReplyMarkup(MarkupBoard.feedbackButtons());
                bot.executeMessage(sendMessage);
                State.setFeedbackState(chatId, FeedbackState.TYPE);
//                uploadPhotoService.uploadFromTelegram(message); TODO chala
            } else {
//                SendMessage sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "upload.photo.again"));
                SendMessage sendMessage = new SendMessage(chatId, "send text message");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
            }
        } else if (State.getFeedbackState(chatId).equals(FeedbackState.TYPE)) {
//            feedbackService.updateTypeById();
            SendMessage sendMessage = new SendMessage(chatId,
                    Emojis.ADD + "added");
            bot.executeMessage(sendMessage);
            State.setFeedbackState(chatId, FeedbackState.UNDEFINED);
        }
    }
}
