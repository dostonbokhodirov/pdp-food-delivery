package uz.pdp.pdp_food_delivery.rest.service.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronJobs {


    @Scheduled(cron = "0/10 * * * * *")
//    @Scheduled(cron = "${jobs.cronSchedule:-}")
    public void writeMessage() {
        System.out.println("Welcome to Tashkent " + new Date());
    }
}
