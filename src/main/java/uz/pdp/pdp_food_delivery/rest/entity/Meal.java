package uz.pdp.pdp_food_delivery.rest.entity;

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

    @Column(nullable = false)
    private LocalDate date;

}
