package uz.pdp.pdp_food_delivery.rest.service.dailymeal;


import org.springframework.data.domain.Pageable;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.DailyMeal;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;

public interface DailyMealService extends GenericCrudService<
        DailyMeal,
        DailyMealDto,
        DailyMealCreateDto,
        DailyMealUpdateDto>, GenericService<DailyMealDto> {

    List<MealDto> getAllByLimit(Pageable pageable);

    List<String> getAllName();


    void truncate();
}
