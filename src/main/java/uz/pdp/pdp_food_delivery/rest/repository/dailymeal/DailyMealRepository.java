package uz.pdp.pdp_food_delivery.rest.repository.dailymeal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.dto.dailymeal.DailyMealDto;
import uz.pdp.pdp_food_delivery.rest.entity.meal.DailyMeal;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal,Long>, BaseRepository {
}
