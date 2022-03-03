package uz.pdp.pdp_food_delivery.rest.repository.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealPicture;

public interface MealPictureRepository extends JpaRepository<MealPicture, Long> {

    //List<MealPicture> findAllByMealId(Long id);
}
