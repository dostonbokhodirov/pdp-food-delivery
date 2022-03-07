package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Meal;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Upload;
import uz.pdp.pdp_food_delivery.rest.mapper.meal.MealMapper;
import uz.pdp.pdp_food_delivery.rest.repository.meal.MealRepository;
import uz.pdp.pdp_food_delivery.rest.service.base.AbstractService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MealServiceIml extends AbstractService<MealMapper, MealRepository>
        implements MealService {

    private final FileUploadService fileUploadService;

    public MealServiceIml(MealMapper mapper, MealRepository repository, FileUploadService fileUploadService) {
        super(mapper, repository);
        this.fileUploadService = fileUploadService;
    }

    @Override
    public Long create(MealCreateDto mealCreateDto) {
        Meal meal = mapper.fromCreateDto(mealCreateDto);
        meal.setDate(LocalDate.now());
        repository.save(meal);
        return meal.getId();
    }

    @Override
    public Long create(MealCreateDto mealCreateDto, Long sesId) {
        Meal meal = mapper.fromCreateDto(mealCreateDto);
        String upload = fileUploadService.upload(mealCreateDto.getPicture());
        meal.setPicture(upload);
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
        Optional<Meal> mealOptional = repository.findById(mealUpdateDto.getId());
        Meal meal=mealOptional.get();
        mapper.fromUpdateDto(mealUpdateDto, meal);
        if (Objects.nonNull(mealUpdateDto.getPicture())) {
            meal.setPicture(fileUploadService.upload(mealUpdateDto.getPicture()));
        }
        repository.save(meal);
    }

    @Override
    public void update(MealUpdateDto mealUpdateDto, Long sesId) {
        Optional<Meal> mealOptional = repository.findById(mealUpdateDto.getId());
        Meal meal=mealOptional.get();
        mapper.fromUpdateDto(mealUpdateDto, meal);
        if (Objects.nonNull(mealUpdateDto.getPicture())) {
            meal.setPicture(fileUploadService.upload(mealUpdateDto.getPicture()));
        }
        meal.setUpdatedBy(sesId);
        repository.save(meal);


    }


    @Override
    public List<MealDto> getAll() {
        List<Meal> meals = repository.findAll();
        return mapper.toDto(meals);
    }

    @Override
    public MealDto get(Long id) {
        Optional<Meal> meal = repository.findById(id);
        return mapper.toDto(meal.get());
    }

    @Override
    public List<MealDto> getAllByLimit(Pageable pageable) {
        return null;//repository.getAllByLimit(pageable);
    }

    @Override
    public MealDto getByPhotoId(String photoId) {
        Meal meal= repository.findByPhotoId(photoId).get();
        return mapper.toDto(meal);
    }
}

