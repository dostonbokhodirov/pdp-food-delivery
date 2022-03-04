package uz.pdp.pdp_food_delivery.rest.entity.meal;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "daily_meal",schema = "daily_meal")
public class DailyMeal extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;

    @Column(name = "picture_path", nullable = false)
    private String picture;

}
