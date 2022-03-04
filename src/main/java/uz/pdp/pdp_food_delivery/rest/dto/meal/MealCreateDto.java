package uz.pdp.pdp_food_delivery.rest.dto.meal;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;

import java.time.LocalDate;

@Getter
@Setter
public class MealCreateDto implements BaseDto {
    private String photoId;
    private String name;
    private LocalDate date;

    public MealCreateDto(String photoId, String name) {
        this.photoId = photoId;
        this.name = name;
    }
}
