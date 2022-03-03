package uz.pdp.pdp_food_delivery.rest.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.pdp_food_delivery.rest.dto.BaseDto;
import uz.pdp.pdp_food_delivery.rest.enums.Department;
import uz.pdp.pdp_food_delivery.rest.enums.Role;

@Getter
@Setter
public class AuthUserCreateDto implements BaseDto {
    public String chatId;

    public AuthUserCreateDto(String chatId) {
        this.chatId = chatId;
    }

    private String password;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String department;

}
