package uz.pdp.pdp_food_delivery.rest.service.feedback;

import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.Feedback;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;

public interface FeedbackService extends GenericCrudService<Feedback, FeedbackDto, FeedbackCreateDto, FeedbackUpdateDto> {
}
