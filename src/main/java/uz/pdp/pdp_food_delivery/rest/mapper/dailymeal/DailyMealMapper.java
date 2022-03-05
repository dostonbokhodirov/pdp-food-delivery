package uz.pdp.pdp_food_delivery.rest.mapper.dailymeal;


import org.mapstruct.Mapper;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.DailyMeal;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyMealMapper extends BaseMapper {


    List<MealDto> toDto(List<DailyMeal> dailyMeals);

    DailyMeal fromCreateDto(DailyMealCreateDto dailyMealCreateDto);

    DailyMealDto toDto(DailyMeal dailyMeal);
}
