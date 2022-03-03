package uz.pdp.pdp_food_delivery.rest.mapper.feedback;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.Feedback;
import uz.pdp.pdp_food_delivery.rest.mapper.BaseMapper;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface FeedbackMapper extends BaseMapper {

    Feedback fromCreateDto(FeedbackCreateDto feedbackCreateDto);

    Feedback fromUpdateDto(FeedbackUpdateDto feedbackUpdateDto);

    List<FeedbackDto> toDto(List<Feedback> feedback);
    FeedbackDto toDto(Feedback feedback);
}
