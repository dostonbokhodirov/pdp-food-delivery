package uz.pdp.pdp_food_delivery.rest.service.meal;

import org.springframework.data.domain.Pageable;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealCreateDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealUpdateDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.Meal;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericCrudService;
import uz.pdp.pdp_food_delivery.rest.service.base.GenericService;

import java.util.List;

public interface MealService extends GenericCrudService<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto>,
        GenericService<MealDto> {

    List<MealDto> getAllByLimit(Pageable pageable);

    MealDto getByPhotoId(String photoId);
}


