package uz.pdp.pdp_food_delivery.rest.entity.meal;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "meal", schema = "meal")
public class Meal extends Auditable {

//    @Column(nullable = false)
    private String photoId;

    @Column(nullable = false)
    private String name;

    private Double price;

    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", nullable = false)
    private MealPicture picture;

}
