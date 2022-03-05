package uz.pdp.pdp_food_delivery.rest.service.feedback;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackDto;
import uz.pdp.pdp_food_delivery.rest.dto.feedback.FeedbackUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.entity.Feedback;
import uz.pdp.pdp_food_delivery.rest.mapper.feedback.FeedbackMapper;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.rest.repository.feedback.FeedbackRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService extends AbstractService<FeedbackMapper, FeedbackRepository>
        implements GenericCrudService<FeedbackCreateDto, FeedbackUpdateDto>, GenericService<FeedbackDto>, BaseService {

    private final AuthUserRepository userRepository;

    public FeedbackService(FeedbackMapper mapper, FeedbackRepository repository, AuthUserRepository userRepository) {
        super(mapper, repository);
        this.userRepository = userRepository;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(FeedbackUpdateDto feedbackUpdateDto) {
        Feedback feedback = mapper.fromUpdateDto(feedbackUpdateDto);
        repository.update(feedback);
    }

    @Override
    public Long create(FeedbackCreateDto feedbackCreateDto) {
        Optional<AuthUser> userOptional = userRepository.findById(feedbackCreateDto.getUser());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        Feedback feedback = mapper.fromCreateDto(feedbackCreateDto);
        feedback.setUser(userOptional.get());
        repository.save(feedback);
        return feedback.getId();
    }

    @Override
    public List<FeedbackDto> getAll() {

        List<Feedback> feedbackList = repository.findAll();

        List<FeedbackDto> returnDtos = new ArrayList<>(Collections.emptyList());

        for (Feedback feedback : feedbackList) {
            returnDtos.add(get(feedback.getId()));
        }

        return returnDtos;
    }

    @Override
    public FeedbackDto get(Long id) {
        Feedback feedback = repository.findById(id).get();
        FeedbackDto feedbackDto = mapper.toDto(feedback);
        feedbackDto.setId(feedback.getUser().getId());
        return feedbackDto;
    }

}
