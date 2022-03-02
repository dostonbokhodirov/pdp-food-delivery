package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.service.mealorder.MealOrderService;

import java.time.LocalTime;

@RestController
public class MealOrderController extends AbstractController<MealOrderService> {


    public MealOrderController(MealOrderService service) {
        super(service);
    }




}
