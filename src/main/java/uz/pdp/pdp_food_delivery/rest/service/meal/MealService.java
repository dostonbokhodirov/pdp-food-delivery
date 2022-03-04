package uz.pdp.pdp_food_delivery.rest.service.meal;

import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.Meal;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MealService extends AbstractService<MealMapper, MealRepository>
        implements GenericCrudService<MealCreateDto, MealUpdateDto>, GenericService<MealDto>, BaseService {

    private final MealPictureService mealPictureService;

    public MealService(MealMapper mapper, MealRepository repository, MealPictureService mealPictureService) {
        super(mapper, repository);
        this.mealPictureService = mealPictureService;
    }

    @Override
    public Long create(MealCreateDto mealCreateDto) {

        Meal meal = mapper.fromCreateDto(mealCreateDto);
        meal.setPicture(mealPictureService.create(mealCreateDto.getPicture()));
        repository.save(meal);

        return meal.getId();

    }

    public Long create(MealCreateDto mealCreateDto, Long sesId) {

        Meal meal = mapper.fromCreateDto(mealCreateDto);
        meal.setCreatedBy(sesId);
        meal.setPicture(mealPictureService.create(mealCreateDto.getPicture()));

        repository.save(meal);

        return meal.getId();

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(MealUpdateDto mealUpdateDto) {

public interface MealService extends GenericCrudService<Meal, MealDto, MealCreateDto, MealUpdateDto> {
}
