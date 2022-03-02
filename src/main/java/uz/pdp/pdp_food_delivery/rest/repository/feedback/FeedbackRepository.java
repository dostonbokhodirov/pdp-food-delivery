package uz.pdp.pdp_food_delivery.rest.repository.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.Feedback;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long>, BaseRepository {


}
