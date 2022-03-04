package uz.pdp.pdp_food_delivery.rest.service.meal;

import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Meal;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

public interface MealService extends GenericCrudService<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto>,
        GenericService<MealDto> {
}


