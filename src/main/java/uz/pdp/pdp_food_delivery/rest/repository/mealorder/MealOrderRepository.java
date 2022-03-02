package uz.pdp.pdp_food_delivery.rest.repository.mealorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.MealOrder;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

@Repository
public interface MealOrderRepository extends JpaRepository<MealOrder,Long>, BaseRepository {


}
