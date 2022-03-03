package uz.pdp.pdp_food_delivery.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealServiceIml;
@RestController
@RequestMapping("/meal/*")
public class MealController extends AbstractController<MealService> {


    public MealController(MealService service) {
        super(service);
    }
}
