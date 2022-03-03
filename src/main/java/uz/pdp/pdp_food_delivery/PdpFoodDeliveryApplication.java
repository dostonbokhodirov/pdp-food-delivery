package uz.pdp.pdp_food_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PdpFoodDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdpFoodDeliveryApplication.class, args);
    }

}
