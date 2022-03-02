package uz.pdp.pdp_food_delivery.rest.entity;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.entity.base.Auditable;

import javax.persistence.Table;

@Getter
@Setter
@Table(name ="meal" ,schema ="meal")
public class Meal extends Auditable {



}
