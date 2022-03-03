package uz.pdp.pdp_food_delivery.telegrambot.processors;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.pdp.pdp_food_delivery.rest.enums.Role;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.telegrambot.LangConfig;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.InlineBoard;
import uz.pdp.pdp_food_delivery.telegrambot.buttons.MarkupBoard;
import uz.pdp.pdp_food_delivery.telegrambot.emojis.Emojis;
import uz.pdp.pdp_food_delivery.telegrambot.enums.MenuState;
import uz.pdp.pdp_food_delivery.telegrambot.enums.UState;

import static uz.pdp.pdp_food_delivery.telegrambot.states.State.setMenuState;
import static uz.pdp.pdp_food_delivery.telegrambot.states.State.setState;

@Component
@RequiredArgsConstructor
public class AuthorizationProcessor {
    private final PdpFoodDeliveryBot bot;
    private final AuthUserRepository authUserRepository;

    public void process(Message message, UState state) {
        String chatId = message.getChatId().toString();

        if (state.equals(UState.ANONYMOUS)) {
            String text = """
                    Tilni tanlang:
                    Выберите язык:
                    Choose your language:""";
            SendMessage sendMessage = new SendMessage(chatId, text);
            sendMessage.setReplyMarkup(InlineBoard.languageButtons());
            bot.executeMessage(sendMessage);
            setState(chatId, UState.DELETE_ALL);
        } else if (UState.FULL_NAME.equals(state)) {
            String text = message.getText();
            if (StringUtils.isNumeric(text) || !text.equals(StringUtils.capitalize(text))) {
                SendMessage sendMessage = new SendMessage(chatId,
                        Emojis.LOOK + " " + LangConfig.get(chatId, "full.name.correctly") + "\n"
                                + LangConfig.get(chatId, "without.numbers"));
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
            } else {
                authUserRepository.updateFullName(chatId, message.getText());
                SendMessage sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "enter.email"));
//                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
                setState(chatId, UState.EMAIL);
            }
        } else if (UState.EMAIL.equals(state)) {
            String text = message.getText();

            boolean matches = text.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+");
            if (!matches) {
                SendMessage sendMessage = new SendMessage(chatId,
                        Emojis.LOOK + " " + LangConfig.get(chatId, "invalid.email"));
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
            } else {
                authUserRepository.updateEmail(chatId, text);
                SendMessage sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "enter.phone") + Emojis.PHONE);
                bot.executeMessage(sendMessage);
            }

        } else if (UState.PHONE_NUMBER.equals(state)) {
            if (message.hasContact()) {
                String phoneNumber = message.getContact().getPhoneNumber();
                if (!phoneNumber.contains("+")) {
                    phoneNumber = "+" + phoneNumber;
                }
                authUserRepository.updatePhone(chatId, phoneNumber);
                SendMessage sendMessage = new SendMessage(chatId, LangConfig.get(chatId, "enter.department") + Emojis.DOWNLOAD);
                bot.executeMessage(sendMessage);
            }


        } else if (UState.DEPARTMENT.equals(state)) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setReplyMarkup(MarkupBoard.department(chatId));
            bot.executeMessage(sendMessage);

            setState(chatId, UState.AUTHORIZED);
            setMenuState(chatId, MenuState.UNDEFINED);
            authUserRepository.updateRole(chatId, Role.USER.toString());

            menuProcessor.menu(chatId, "USER", botService.getMessage(chatId));
        }

    }
}