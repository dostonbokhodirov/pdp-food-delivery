package uz.pdp.pdp_food_delivery.rest.service.feedback;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.mapper.feedback.FeedbackMapper;
import uz.pdp.pdp_food_delivery.rest.repository.feedback.FeedbackRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;

@Service
public class FeedbackService extends AbstractService<FeedbackMapper, FeedbackRepository>
        implements GenericCrudService<FeedbackCreateDto, FeedbackUpdateDto> , GenericService<FeedbackDto> {

    public FeedbackService(FeedbackMapper mapper, FeedbackRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(FeedbackUpdateDto feedbackUpdateDto) {

    }

    @Override
    public void create(FeedbackCreateDto feedbackCreateDto) {

    }

    @Override
    public List<FeedbackDto> getAll() {
        return null;
    }

    @Override
    public FeedbackDto get(Long id) {
        return null;
    }

}