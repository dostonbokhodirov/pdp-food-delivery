package uz.pdp.pdp_food_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;

@SpringBootApplication
public class PdpFoodDeliveryApplication {

    private static PdpFoodDeliveryBot bot;

    public static void main(String[] args) {
        SpringApplication.run(PdpFoodDeliveryApplication.class, args);
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
