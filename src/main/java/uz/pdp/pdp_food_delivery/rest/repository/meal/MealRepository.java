package uz.pdp.pdp_food_delivery.rest.repository.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.Meal;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long>, BaseRepository {


}
