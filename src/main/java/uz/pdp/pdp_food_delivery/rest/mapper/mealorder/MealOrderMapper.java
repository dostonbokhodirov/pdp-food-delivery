package uz.pdp.pdp_food_delivery.rest.mapper.mealorder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.mealorder.MealOrderDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealOrder;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MealOrderMapper extends BaseMapper {

    MealOrderDto toDto(MealOrder order);

    List<MealOrderDto> toDto(List<MealOrder> orders);

    List<MealOrderCreateDto> toCreateDto(List<MealOrder> orders);

    MealOrder fromCreateDto(MealOrderCreateDto orderCreateDto);

    MealOrder fromUpdateDto(MealOrderDto orderUpdateDto);

}
