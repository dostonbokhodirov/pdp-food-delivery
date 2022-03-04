package uz.pdp.pdp_food_delivery.rest.entity.meal;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name ="meal" ,schema ="meal")
public class Meal extends Auditable {

    @Column(nullable = false)
    private String name;

    private Double price;

    @Column(nullable = false)
    private Date date;

    @Column(name = "picture_id", nullable = false)
    private String picture;

}
