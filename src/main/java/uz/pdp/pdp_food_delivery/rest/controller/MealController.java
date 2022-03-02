package uz.pdp.pdp_food_delivery.rest.controller;

import uz.pdp.pdp_food_delivery.rest.controller.base.AbstractController;
import uz.pdp.pdp_food_delivery.rest.service.meal.MealService;

public class MealController extends AbstractController<MealService> {


    public MealController(MealService service) {
        super(service);
    }
}
