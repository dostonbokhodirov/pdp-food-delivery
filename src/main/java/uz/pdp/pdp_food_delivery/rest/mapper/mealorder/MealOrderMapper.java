package uz.pdp.pdp_food_delivery.rest.mapper.mealorder;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.MealOrder;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;


@Component
@Mapper(componentModel = "spring")
public interface MealOrderMapper extends BaseMapper<
        MealOrder,
        MealOrderDto,
        MealOrderCreateDto,
        MealOrderUpdateDto> {

}
