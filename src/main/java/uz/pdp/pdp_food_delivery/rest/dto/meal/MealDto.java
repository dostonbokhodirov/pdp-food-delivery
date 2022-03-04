package uz.pdp.pdp_food_delivery.rest.dto.meal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.pdp_food_delivery.rest.dto.GenericDto;

import java.time.LocalDate;

@Getter
@Setter
public class MealDto extends GenericDto {
    private String photoId;

    private MultipartFile picture;

    private String name;
    private LocalDate date;
}
