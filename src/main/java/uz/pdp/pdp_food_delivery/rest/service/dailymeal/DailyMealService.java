package uz.pdp.pdp_food_delivery.rest.service.dailymeal;


import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.DailyMeal;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

public interface DailyMealService extends GenericCrudService<
        DailyMeal,
        DailyMealDto,
        DailyMealCreateDto,
        DailyMealUpdateDto>, GenericService<DailyMealDto> {

}
