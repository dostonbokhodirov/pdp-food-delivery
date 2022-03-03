package uz.pdp.pdp_food_delivery.rest.service.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CronJobs {


    @Scheduled(cron="0/30 0 3-4 * * *")
    public void writeMessage(){
        System.out.println("Welcome to Tashkent " + new Date());
    }
}
