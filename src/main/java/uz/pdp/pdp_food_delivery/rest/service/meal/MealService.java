package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Meal;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealPicture;
import uz.pdp.pdp_food_delivery.rest.mapper.meal.MealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;
import uz.pdp.pdp_food_delivery.rest.service.base.BaseService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.time.LocalDate;
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
        MealPicture mealPicture = mealPictureService.create(mealCreateDto.getPicture());

        meal.setPicture(mealPicture);

        repository.save(meal);

        return meal.getId();

    }

    public Long create(MealCreateDto mealCreateDto, Long sesId) {

        Meal meal = mapper.fromCreateDto(mealCreateDto);
        MealPicture mealPicture = mealPictureService.create(mealCreateDto.getPicture());

        meal.setPicture(mealPicture);
        meal.setCreatedBy(sesId);

        repository.save(meal);

        return meal.getId();

    }

    @Override
    public void delete(Long id) {
        Optional<Meal> meal = repository.findByIdAndDeleted(id, false);
        meal.ifPresentOrElse(
                (value) ->
                        value.setDeleted(true),
                () -> {
                    throw new RuntimeException("meal not found");
                });
        repository.save(meal.get());
    }

    public void delete(Long id, Long sesId) {
        Optional<Meal> meal = repository.findByIdAndDeleted(id, false);
        meal.ifPresentOrElse(
                (value) ->
                        value.setDeleted(true),
                () -> {
                    throw new RuntimeException("meal not found");
                });
        meal.get().setUpdatedBy(sesId);
        repository.save(meal.get());
    }

    @Override
    public void update(MealUpdateDto mealUpdateDto) {

        Optional<Meal> meal = repository.findById(mealUpdateDto.getId());
        mapper.fromUpdateDto(mealUpdateDto, meal.get());

        if (Objects.nonNull(mealUpdateDto.getPicture())) {
            meal.get().setPicture(mealPictureService.create(mealUpdateDto.getPicture()));
        }
        repository.save(meal.get());
    }

    public void update(MealUpdateDto mealUpdateDto, Long sesId) {

        Optional<Meal> meal = repository.findById(mealUpdateDto.getId());

        mapper.fromUpdateDto(mealUpdateDto, meal.get());

        if (Objects.nonNull(mealUpdateDto.getPicture())) {
            meal.get().setPicture(mealPictureService.create(mealUpdateDto.getPicture()));
        }

        meal.get().setUpdatedBy(sesId);
        repository.save(meal.get());


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
