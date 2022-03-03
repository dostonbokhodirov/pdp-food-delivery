package uz.pdp.pdp_food_delivery.rest.entity.meal;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "meal")
public class MealPicture extends Auditable {

    @Column(name = "generated_name")
    private String generatedName;

    @Column(name = "image_name")
    private String imageName;

    private String code;

    @Column
    private String format;

    @Column
    private Long size;

}