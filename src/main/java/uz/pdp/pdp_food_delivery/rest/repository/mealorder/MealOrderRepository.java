package uz.pdp.pdp_food_delivery.rest.repository.mealorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.meal.MealOrder;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MealOrderRepository extends JpaRepository<MealOrder,Long>, BaseRepository {


    @Query(value="select * from meal_order.meal_order m where cast(m.created_at as date) = :date", nativeQuery = true)
    List<MealOrder> findByDate(@Param("date") Date date);

}
