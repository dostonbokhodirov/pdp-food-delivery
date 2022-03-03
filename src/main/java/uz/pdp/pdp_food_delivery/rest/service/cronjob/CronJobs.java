package uz.pdp.pdp_food_delivery.rest.service.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.pdp_food_delivery.telegrambot.PdpFoodDeliveryBot;

import java.util.Date;

@Component
public class CronJobs {




    @Scheduled(cron = "0/10 * * * * *")
//    @Scheduled(cron = "${jobs.cronSchedule:-}")
    public void writeMessage() {
        System.out.println("hello "+ new Date());
    }
}
