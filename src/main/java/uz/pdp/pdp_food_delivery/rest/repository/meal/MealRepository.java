package uz.pdp.pdp_food_delivery.rest.repository.meal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.Meal;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>, BaseRepository {

//    @Query(value = 'select * from books where name like \'%s\' limit \'%s\' offset :

    List<Meal> getAllByLimit(@Param(value = "limit") Integer limitState, @Param(value = "offset") Integer offset);

}
