package uz.pdp.pdp_food_delivery.rest.dto.meal;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;

import java.util.Date;

@Getter
@Setter
public class MealCreateDto implements BaseDto {

    private MultipartFile picture;

    private String name;

    private Date date;
}
