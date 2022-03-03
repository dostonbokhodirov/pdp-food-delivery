package uz.pdp.pdp_food_delivery.rest.service.feedback;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.mapper.feedback.FeedbackMapper;
import uz.pdp.pdp_food_delivery.rest.repository.feedback.FeedbackRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;

import java.util.List;

@Service
public class FeedbackServiceIml extends AbstractService<FeedbackMapper, FeedbackRepository>
        implements FeedbackService {

    public FeedbackServiceIml(FeedbackMapper mapper, FeedbackRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Void update(FeedbackUpdateDto feedbackUpdateDto) {

        return null;
    }

    @Override
    public Long create(FeedbackCreateDto feedbackCreateDto) {

        return null;
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
