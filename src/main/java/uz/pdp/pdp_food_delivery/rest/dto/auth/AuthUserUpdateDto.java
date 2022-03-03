package uz.pdp.pdp_food_delivery.rest.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.dto.GenericDto;

@Getter
@Setter
public class AuthUserUpdateDto  extends GenericDto {
    public String fullName;

    public AuthUserUpdateDto(String fullName) {
        this.fullName = fullName;
    }
}
