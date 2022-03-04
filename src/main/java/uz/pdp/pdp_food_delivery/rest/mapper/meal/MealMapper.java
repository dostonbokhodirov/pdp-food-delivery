package uz.pdp.pdp_food_delivery.rest.mapper.meal;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.entity.Meal;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MealMapper extends BaseMapper {


    List<MealDto> toDto(List<Meal> meals);

    Meal fromCreateDto(MealCreateDto mealCreateDto);

    MealDto toDto(Meal meal);
}
