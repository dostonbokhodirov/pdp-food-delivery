package uz.pdp.pdp_food_delivery.rest.mapper.mealorder;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MealOrderMapper extends BaseMapper {

}
