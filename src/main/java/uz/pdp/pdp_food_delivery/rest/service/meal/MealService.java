package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.mapper.meal.MealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;

@Service
public class MealService  extends AbstractService<MealMapper, MealRepository>
        implements GenericCrudService<MealCreateDto, MealUpdateDto>, GenericService<MealDto>, BaseService {

    public MealService(MealMapper mapper, MealRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(MealUpdateDto mealUpdateDto) {

    }

    @Override
    public void create(MealCreateDto mealCreateDto) {

    }

    @Override
    public List<MealDto> getAll() {
        return null;
    }

    @Override
    public MealDto get(Long id) {
        return null;
    }
}
