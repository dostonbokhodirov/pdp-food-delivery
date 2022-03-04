package uz.pdp.pdp_food_delivery.rest.mapper.dailymeal;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.DailyMeal;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;
@Component
@Mapper(componentModel = "spring")
public interface DailyMealMapper extends BaseMapper<
        DailyMeal,
        DailyMealDto,
        DailyMealCreateDto,
        DailyMealUpdateDto> {


}
