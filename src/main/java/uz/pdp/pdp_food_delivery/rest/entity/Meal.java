package uz.pdp.pdp_food_delivery.rest.entity;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name ="meal" ,schema ="meal")
public class Meal extends Auditable {

    private byte[] picture;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;

}
