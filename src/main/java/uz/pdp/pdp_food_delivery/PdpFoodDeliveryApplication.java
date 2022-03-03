package uz.pdp.pdp_food_delivery;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PdpFoodDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdpFoodDeliveryApplication.class, args);
    }

}
