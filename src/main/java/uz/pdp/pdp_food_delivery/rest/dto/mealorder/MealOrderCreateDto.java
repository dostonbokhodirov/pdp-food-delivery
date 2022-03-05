package uz.pdp.pdp_food_delivery.rest.dto.mealorder;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;
import uz.pdp.pdp_food_delivery.rest.dto.auth.AuthUserDto;
import uz.pdp.pdp_food_delivery.rest.dto.meal.MealDto;

@Getter
@Setter
public class MealOrderCreateDto implements BaseDto {
    private Long userId;
    private Long mealId;
    private boolean done;

    public MealOrderCreateDto(Long userId,Long mealId) {
        this.userId = userId;
        this.mealId = mealId;
    }
}
