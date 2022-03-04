package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.Meal;
import uz.pdp.pdp_food_delivery.rest.mapper.meal.MealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService extends AbstractService<MealMapper, MealRepository>
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
    public Long create(MealCreateDto mealCreateDto) {
        Meal meal = mapper.fromCreateDto(mealCreateDto);
        meal.setDate(LocalDate.now());
        Meal save = repository.save(meal);
        return save.getId();
    }

    @Override
    public List<MealDto> getAll() {
        List<Meal> meals = repository.findAll();
        return mapper.toDto(meals);
    }

    @Override
    public MealDto get(Long id) {
        Meal meal = repository.findById(id).orElseThrow(() -> new RuntimeException("Meal Not Found"));
        return mapper.toDto(meal);
    }

    public List<MealDto> getAllByLimit(Pageable pageable) {
        List<Meal> meals = repository.findAll(pageable).getContent();
        return mapper.toDto(meals);
    }

}
