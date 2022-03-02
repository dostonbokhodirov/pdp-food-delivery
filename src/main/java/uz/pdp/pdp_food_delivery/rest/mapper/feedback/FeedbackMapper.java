package uz.pdp.pdp_food_delivery.rest.mapper.feedback;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;


//@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FeedbackMapper extends BaseMapper {
}
